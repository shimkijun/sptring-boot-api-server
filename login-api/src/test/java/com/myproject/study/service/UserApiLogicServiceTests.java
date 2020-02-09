package com.myproject.study.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class UserApiLogicServiceTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserApiLogicService userApiLogicService;

    @DisplayName("로그인 성공 테스트")
    @Test
    void authenticateWithValidAttributes() {
        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("test@naver.com")
                .password("test")
                .build();

        User mockUser = User.builder()
                .email(userApiRequest.getEmail()).build();

        given(userRepository.findByEmail(userApiRequest.getEmail()))
                .willReturn(Optional.of(mockUser));

        User user = userApiLogicService.authenticate(userApiRequest);

        assertEquals(user.getEmail(),userApiRequest.getEmail());
    }

    @DisplayName("이메일이 없을때")
    @Test
    void authenticateWithNotExistedEmail() {
        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("x@naver.com")
                .password("test")
                .build();

        given(userRepository.findByEmail(userApiRequest.getEmail()))
                .willReturn(Optional.empty());

        User user = userApiLogicService.authenticate(userApiRequest);

    }
}