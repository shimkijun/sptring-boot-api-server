package com.myproject.study.service;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.enumclass.UserStatus;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.Pagination;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.model.network.response.UserOrderInfoApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User> {

    public final PasswordEncoder passwordEncoder;

    public UserApiLogicService(JpaRepository<User, Long> baseRepository, PasswordEncoder passwordEncoder) {
        super(baseRepository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Header<UserApiResponse> create(UserApiRequest request) {

        String encoderPassword =  passwordEncoder.encode(request.getPassword());

        // user 생성
        User user = User.builder()
                .password(encoderPassword)
                .status(UserStatus.REGISTERED)
                .email(request.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = baseRepository.save(user);
        // 생성된 데이터 -> userApiResponse return
        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(user -> response(user))
                .map(Header::OK)
                .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest body = request.getData();

        Optional<User> user = baseRepository.findById(body.getId());

        return user.map(getUser -> {
            getUser.setPassword(body.getPassword())
                    .setStatus(body.getStatus())
                    .setEmail(body.getEmail());

            return getUser;
        }).map(saveUser -> baseRepository.save(saveUser))
        .map(updateUser -> response(updateUser))
        .map(Header::OK)
        .orElseGet(() -> Header.ERROR("데이터가 없습니다."));
    }

    @Override
    public Header delete(Long id) {
        Optional<User> user = baseRepository.findById(id);
        return user.map(getUser -> {
            baseRepository.delete(getUser);

            return Header.OK();
        })
        .orElseGet(() -> Header.ERROR("데이터가 없습니다."));
    }

    public Header<List<UserApiResponse>> search(Pageable pageable) {

        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponses = users.stream()
                .map(user -> response(user))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(users.getTotalPages())
                .totalElements(users.getTotalElements())
                .currentPage(users.getNumber())
                .currentElements(users.getNumberOfElements())
                .build();

        return Header.OK(userApiResponses,pagination);
    }



//    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {
//        User user = baseRepository.getOne(id);
//        UserApiResponse userApiResponse = response(user);
//
//        List<OrderGroup> orderGroups = user.getOrderGroups();
//        List<OrderGroupApiResponse> orderGroupApiResponses = orderGroups.stream()
//                .map(orderGroup -> {
//                })
//
//    }

    public UserApiResponse response(User user){

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();

        return userApiResponse;
    }

    public Header<UserOrderInfoApiResponse> orderInfo(Long id) {
        return null;
    }
}
