package com.myproject.study.service;

import com.myproject.study.model.entity.Account;
import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.security.AccountContext;
import com.myproject.study.security.jwt.JWTFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JWTFactoryTest {

    private Logger log = LoggerFactory.getLogger(JWTFactoryTest.class);

    private  AccountContext context;

    @Autowired
    private JWTFactory factory;

    @BeforeEach
    void setUp(){
        Account account = Account.builder()
                .id(1L)
                .username("심기준")
                .userId("skj")
                .password("1234")
                .userRole(UserRole.USER)
                .socialId(100L)
                .build();
        this.context = AccountContext.fromAccountModel(account);
    }

    @Test
    void createJwt(){
        log.info("{}",factory.generateToken(this.context));
    }
}