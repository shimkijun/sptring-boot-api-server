package com.myproject.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.AccessToken;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.service.UserApiLogicService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SessionControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserApiLogicService userApiLogicService;

    @DisplayName("로그인 테스트")
    @Test
    void authenticateEmail() throws Exception{

        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("test@naver.com")
                .build();

        AccessToken accessToken = AccessToken.builder()
                .accessToken("ACCESSTOKEN")
                .build();

        mvc.perform(post("/api/login/session")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userApiRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string((objectMapper.writeValueAsString(accessToken))));

        verify(userApiLogicService).authenticate(userApiRequest);
    }

}