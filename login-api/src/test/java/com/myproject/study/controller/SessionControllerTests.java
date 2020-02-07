package com.myproject.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.AccessToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SessionControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("일반회원 로그인 테스트")
    @Test
    void create() throws Exception{

        User user = User.builder()
                .email("test@naver.com")
                .password("test")
                .build();

        AccessToken accessToken = AccessToken.builder()
                .accessToken("ACCESSTOKEN")
                .build();

        mvc.perform(post("/api/login/session")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(content().string((objectMapper.writeValueAsString(accessToken))));

    }

}