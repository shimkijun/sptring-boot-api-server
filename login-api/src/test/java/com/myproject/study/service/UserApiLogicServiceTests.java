package com.myproject.study.service;

import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.model.enumclass.UserStatus;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.repository.UserRepository;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
class UserApiLogicServiceTests {

    @MockBean
    private UserApiLogicService userApiLogicService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @DisplayName("회원가입 성공")
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

    @DisplayName("사용중인 이메일")
    @Test
    void createUserWithExistedEmail(){
        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("tester@naver.com")
                .build();


       given(userApiLogicService.lookup(userApiRequest)).willReturn(Header.OK(response(userApiRequest)));

       Header<UserApiResponse> user = userApiLogicService.lookup(userApiRequest);

       verify(userApiLogicService).lookup(userApiRequest);

       assertEquals(user.getResultCode(),"OK");
    }

    @DisplayName("사용가능한 이메일")
    @Test
    void createUserWithNotExistedEmail(){
        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email("gsdafasd@naver.com")
                .build();


        given(userApiLogicService.lookup(userApiRequest)).willReturn(Header.ERROR(""));

        Header<UserApiResponse> user = userApiLogicService.lookup(userApiRequest);

        verify(userApiLogicService).lookup(userApiRequest);

        assertEquals(user.getResultCode(),"ERROR");
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