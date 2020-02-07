package com.myproject.study.service;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.repository.UserApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApiLogicService {

    private final UserApiRepository userApiRepository;

    public Header<UserApiResponse> authenticate(UserApiRequest request) {
        return userApiRepository.findByEmailAndPassword(request);
    }

}
