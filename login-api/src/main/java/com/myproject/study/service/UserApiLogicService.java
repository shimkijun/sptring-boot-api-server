package com.myproject.study.service;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserApiLogicService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User authenticate(UserApiRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            return null;
        };
        return user;
    }


}
