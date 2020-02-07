package com.myproject.study.controller;

import com.myproject.study.model.network.AccessToken;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.service.UserApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class SessionController {

    private final UserApiLogicService userApiLogicService;

    @PostMapping("/session")
    public Header<UserApiResponse> create(
            @RequestBody UserApiRequest request
            ){
        String token = "ACCESSTOKEN";
        AccessToken accessToken = AccessToken.builder()
                        .accessToken(token).build();

        return userApiLogicService.authenticate(request);
    }

}
