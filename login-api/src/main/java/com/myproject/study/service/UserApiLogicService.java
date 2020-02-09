package com.myproject.study.service;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserApiLogicService {

    private final UserRepository userRepository;

    public User authenticate(UserApiRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);
        return user;
    }

}
