package com.myproject.study.controller;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.AccessToken;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.service.UserApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/signin")
public class SessionController {

    private final UserApiLogicService userApiLogicService;

    @PostMapping("/session")
    public ResponseEntity<?> create(@RequestBody UserApiRequest request) throws URISyntaxException {
        String token = "ACCESSTOKEN";
        AccessToken accessToken = AccessToken.builder()
                        .accessToken(token).build();
        String url = "/api/login/session";

        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userApiLogicService.authenticate(userApiRequest);

        return ResponseEntity.created(new URI(url))
                .body(accessToken);
    }

    @PostMapping("/lookup")
    public ResponseEntity<?> emailExistValidate(@RequestBody UserApiRequest request) throws URISyntaxException {

        UserApiRequest userApiRequest = UserApiRequest.builder()
                .email(request.getEmail())
                .build();

        User user = userApiLogicService.emailExistLookup(userApiRequest);
        System.out.println(user);
        return ResponseEntity.ok()
                .body(user);
    }

}
