package com.myproject.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.study.model.entity.User;
import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.model.enumclass.UserStatus;
import com.myproject.study.model.network.AccessToken;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.service.UserApiLogicService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class UserApiControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserApiLogicService userApiLogicService;

    @DisplayName("사용중인 이메일")
    @Test
    void emailLookup() throws Exception{

        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("test@naver.com")
                .build();

        mvc.perform(post("/api/user/lookup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userApiRequest)))
                .andDo(print());

        verify(userApiLogicService).lookup(eq(userApiRequest));
    }

    @DisplayName("일반회원 가입 테스트")
    @Test
    void create() throws Exception{

        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("test@naver.com")
                .nickname("test")
                .password("1234")
                .status(UserStatus.REGISTERED)
                .role(UserRole.USER)
                .build();

        mvc.perform(post("/api/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userApiRequest)))
                .andDo(print());

        verify(userApiLogicService).create(eq(userApiRequest));
    }



}