package com.myproject.study.repository;

import com.myproject.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailRepositoryTests {

    private Logger log = LoggerFactory.getLogger(OrderDetailRepositoryTests.class);


    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void create(){
        OrderDetail orderDetail = OrderDetail.builder()
                .status("WAITING")
                .arrivalDate(LocalDateTime.now().plusDays(2))
                .quantity(1)
                .totalPrice(BigDecimal.valueOf(900000))
                .createdAt(LocalDateTime.now())
                .createdBy("Admin")
                .build();

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        assertNotNull(newOrderDetail);
        log.info("orderDetail => {}",orderDetail);
    }

    @Test
    void read(){
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);

        orderDetail.ifPresent(getOrderDeatail -> {
            assertNotNull(getOrderDeatail);
            log.info("orderDetail => {}",getOrderDeatail);
        });
    }
}