package com.myproject.study.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.myproject.study.security.exception.InvalidJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class JwtDecoder {

    public AccountContext decodeJwt(String token){
        DecodedJWT decodedJWT = isValidToken(token).orElseThrow(() -> new InvalidJwtException("유요한 토큰이 아닙니다."));

        String username = decodedJWT.getClaim("USERNAME").asString();
        String role = decodedJWT.getClaim("USER_ROLE").asString();

        return new AccountContext(username,"empty",role);
    }

    private Optional<DecodedJWT> isValidToken(String token){
        DecodedJWT jwt = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256("jwttest");
            JWTVerifier verifier = JWT.require(algorithm).build();

            jwt = verifier.verify(token);

        }catch (Exception e){
            log.error(e.getMessage());
        }

        return Optional.ofNullable(jwt);
    }

}
