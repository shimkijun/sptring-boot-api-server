package com.myproject.study.repository;

import com.myproject.study.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminUserRepositoryTests {

    private Logger log = LoggerFactory.getLogger(AdminUserRepositoryTests.class);

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    void create(){

        AdminUser adminUser = AdminUser.builder()
                .account("Admin")
                .password("admin")
                .status("REGISTERED")
                .role("SUPER")
                .build();

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        assertNotNull(newAdminUser);
        log.info("{}",newAdminUser);
    }
}