package com.myproject.study.repository;

import com.myproject.study.model.entity.User;
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
                .account("TestUser01")
                .email("TestUser01@gmail.com")
                .phoneNumber("010-1111-1111")
                .createdAt(LocalDateTime.now())
                .createdBy("TestUser01")
                .build();
        User newUser = userRepository.save(user);
        log.info("USER => {}",newUser);
        assertEquals(newUser.getAccount(),"TestUser01");
    }

    @Test
    void read(){
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(getUser -> log.info("USER => {}",getUser));
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