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
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class UserApiLogicServiceTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserApiLogicService userApiLogicService;



}