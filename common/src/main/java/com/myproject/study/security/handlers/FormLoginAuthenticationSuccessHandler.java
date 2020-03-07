package com.myproject.study.security.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.study.model.network.response.TokenResponse;
import com.myproject.study.security.AccountContext;
import com.myproject.study.security.jwt.JWTFactory;
import com.myproject.study.security.tokens.PostAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FormLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JWTFactory factory;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication auth
    ) throws IOException{

        PostAuthorizationToken token = (PostAuthorizationToken) auth;
        AccountContext context = (AccountContext) token.getPrincipal();
        String tokenResult = factory.generateToken(context);

        processResponse(response,writeResponse(tokenResult));

    }

    private TokenResponse writeResponse(String token){
        return new TokenResponse(token);
    }

    private void processResponse(HttpServletResponse res, TokenResponse response) throws JsonProcessingException,IOException {

        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.setCharacterEncoding("UTF-8");
        res.setStatus(HttpStatus.OK.value());
        res.getWriter().write(objectMapper.writeValueAsString(response));

    }
}
