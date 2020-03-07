package com.myproject.study.service;

import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.model.enumclass.UserStatus;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.BDDMockito.given;


@SpringBootTest
class UserApiLogicServiceTest {

    @MockBean
    private UserApiLogicService userApiLogicService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void create() {

        String encoder = passwordEncoder.encode("1234");

        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("test@naver.com")
                .nickname("test")
                .password(encoder)
                .status(UserStatus.REGISTERED)
                .role(UserRole.USER)
                .build();

        given(userApiLogicService.create(userApiRequest)).willReturn(Header.OK(response(userApiRequest)));

    }

    @Test
    void createUserWithExistedEmail() {

        String encoder = passwordEncoder.encode("1234");

        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("test@naver.com")
                .nickname("test")
                .password(encoder)
                .status(UserStatus.REGISTERED)
                .role(UserRole.USER)
                .build();

        given(userApiLogicService.create(userApiRequest)).willReturn(Header.OK(response(userApiRequest)));

    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }



    public UserApiResponse response(UserApiRequest user){

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .status(user.getStatus())
                .userRole(user.getRole())
                .build();

        return userApiResponse;
    }
}