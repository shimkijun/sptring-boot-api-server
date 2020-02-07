package com.myproject.study.repository;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.enumclass.UserStatus;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTests{

    private Logger log = LoggerFactory.getLogger(UserRepositoryTests.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    void create(){
        User user = User.builder()
                .account("TestUser03")
                .password("test")
                .status(UserStatus.REGISTERED)
                .email("TestUser03@gmail.com")
                .phoneNumber("010-3333-3333")
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);
        assertNotNull(newUser);
        log.info("USER => {}",newUser);

        userRepository.save(newUser);
    }

    @Test
    @Transactional
    void read(){
        Optional<User> user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");
        user.ifPresent(getOrderGroups ->{
            getOrderGroups.getOrderGroups().forEach(getOrderGroup -> {
                                log.info("{}", getOrderGroup);
                                getOrderGroup.getOrderDetails().forEach(
                                        orderDetail -> {
                                            log.info("{}",orderDetail);
                                            log.info("{}",orderDetail.getItem());
                                            log.info("{}",orderDetail.getItem().getPartner());
                                            log.info("{}",orderDetail.getItem().getPartner().getCategory());
                                        });
                            });
        });

    }

    @Test
    void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(getUser -> {
            getUser.setAccount("pppp");
            getUser.setUpdatedAt(LocalDateTime.now());
            getUser.setUpdatedBy("update method()");

            User newUser = userRepository.save(getUser);
            log.info("update user => {}",newUser);
        });
    }

    @Test
    @Transactional
    void delete(){
        Optional<User> user = userRepository.findById(3L);

        // true
        assertTrue(user.isPresent());

        user.ifPresent(getUser -> {
            userRepository.delete(getUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        // false
        assertFalse(deleteUser.isPresent());
    }

}