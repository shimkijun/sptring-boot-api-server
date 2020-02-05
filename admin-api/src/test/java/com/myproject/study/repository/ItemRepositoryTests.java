package com.myproject.study.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTests {

    private Logger log = LoggerFactory.getLogger(ItemRepository.class);

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void create(){

    }

}