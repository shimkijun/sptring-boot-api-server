package com.myproject.study.repository;

import com.myproject.study.model.entity.Partner;
import com.myproject.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PartnerRepositoryTests {

    private Logger log = LoggerFactory.getLogger(PartnerRepositoryTests.class);

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    void create(){
        Partner partner = Partner.builder()
                .name("Partner01")
                .status("REGISTERED")
                .address("서울시 강남구")
                .callCenter("070-1111-1111")
                .partnerNumber("010-1111-1111")
                .businessNumber("1234567890123")
                .ceoName("홍길동")
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Admin")
                .build();

        Partner newPartner = partnerRepository.save(partner);
        assertNotNull(newPartner);
        log.info("partner => {}",newPartner);

    }

    @Test
    void read(){
        Optional<Partner> partner = partnerRepository.findById(1L);
        assertNotNull(partner.isPresent());
        log.info("partner => {}",partner);
    }
}