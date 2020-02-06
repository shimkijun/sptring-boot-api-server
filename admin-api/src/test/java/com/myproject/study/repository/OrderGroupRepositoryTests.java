package com.myproject.study.repository;

import com.myproject.study.model.entity.OrderGroup;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderGroupRepositoryTests {

    private Logger log = LoggerFactory.getLogger(OrderGroupRepositoryTests.class);

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    void create(){
        OrderGroup orderGroup = OrderGroup.builder()
                .status("COMPLETE")
                .orderType("ALL")
                .revName("홍길동")
                .paymentType("CARD")
                .totalPrice(BigDecimal.valueOf(900000))
                .totalQuantity(1)
                .orderAt(LocalDateTime.now().minusDays(2))
                .arrivalDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Admin")
                .build();

        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        assertNotNull(newOrderGroup);
        log.info("orderGroup => {}",newOrderGroup);
    }
}