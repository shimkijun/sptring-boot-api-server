package com.myproject.study.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class JWTFactory {

    private static String signinKey = "jwttest";

    public String generateToken(AccountContext context){
        String token = null;

        try{
            token = JWT.create()
                    .withIssuer("ADMIN")
                    .withClaim("USERNAME",context.getAccount().getUserId())
                    .withClaim("USER_ROLE",context.getAccount().getUserRole().getTitle())
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return token;
    }

    private Algorithm generateAlgorithm(){
        return Algorithm.HMAC256(signinKey);
    }
}
