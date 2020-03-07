package com.myproject.study.service;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.model.enumclass.UserStatus;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;


@Service
@Transactional
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User>{

    private final PasswordEncoder passwordEncoder;

    public UserApiLogicService(JpaRepository<User, Long> baseRepository, PasswordEncoder passwordEncoder) {
        super(baseRepository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Header<UserApiResponse> create(UserApiRequest request) {

        String encoderPassword =  passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .password(encoderPassword)
                .email(request.getEmail())
                .nickname(request.getNickname())
                .status(UserStatus.REGISTERED)
                .role(UserRole.USER)
                .registeredAt(LocalDateTime.now())
                .build();

        User newUser = baseRepository.save(user);

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
                .nickname(user.getNickname())
                .status(user.getStatus())
                .userRole(user.getRole())
                .build();

        return userApiResponse;
    }
}
