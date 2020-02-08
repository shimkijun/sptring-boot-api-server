package com.myproject.study.repository;

import com.myproject.study.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockRepositoryTests {

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void create(){
        Block block = Block.builder()
                .name("test")
                .reason("그냥")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();

        blockRepository.save(block);

        List<Block> blocks = blockRepository.findAll();

        assertEquals(blocks.size(),1);
        assertEquals(blocks.get(0).getName(),"test");
    }

}