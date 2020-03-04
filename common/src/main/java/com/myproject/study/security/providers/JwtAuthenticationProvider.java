package com.myproject.study.security.providers;

import com.myproject.study.security.AccountContext;
import com.myproject.study.security.jwt.JwtDecoder;
import com.myproject.study.security.tokens.JwtPreProcessingToken;
import com.myproject.study.security.tokens.PostAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtDecoder jwtDecoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = (String)authentication.getPrincipal();
        AccountContext context = jwtDecoder.decodeJwt(token);
        return PostAuthorizationToken.getTokenFromAccountContext(context);

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreProcessingToken.class.isAssignableFrom(authentication);
    }
}
