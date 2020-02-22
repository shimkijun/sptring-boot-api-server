package com.myproject.study.service;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.enumclass.UserStatus;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {

    private final PasswordEncoder passwordEncoder;

    public UserApiLogicService(JpaRepository<User, Long> baseRepository, PasswordEncoder passwordEncoder) {
        super(baseRepository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Header<UserApiResponse> create(UserApiRequest request) {

        String encodePassword = passwordEncoder.encode(request.getPassword());

        // user 생성
        User user = User.builder()
                .password(encodePassword)
                .status(UserStatus.REGISTERED)
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = baseRepository.save(user);

        // 생성된 데이터 -> userApiResponse return
        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }

    public UserApiResponse response(User user){

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .build();

        return userApiResponse;
    }
}
