package com.myproject.study.repository;

import com.myproject.study.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTests {

    private Logger log = LoggerFactory.getLogger(ItemRepositoryTests.class);

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void create(){
        Item item = Item.builder()
                .status("UNREGISTERED")
                .name("삼성 노트북")
                .title("삼성 노트북 A100")
                .content("2020년형 노트북")
                .price(BigDecimal.valueOf(900000))
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("Partner01")
                .build();

        Item newItem = itemRepository.save(item);
        assertNotNull(newItem);

        log.info("item => {}",newItem);
    }

    @Test
    void read(){

    }

}