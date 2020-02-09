package com.myproject.study;

import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApiApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("로그인 정상처리")
    @Test
    void contextLoads() {
        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("test@naver.com")
                .password("test")
                .build();
    }

}
