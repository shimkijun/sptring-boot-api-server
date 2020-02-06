package com.myproject.study.repository;

import com.myproject.study.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTests {

    private Logger log = LoggerFactory.getLogger(CategoryRepositoryTests.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type ="COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "Admin";

        Category category = Category.builder()
                .type(type)
                .title(title)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .build();

        Category newCategory = categoryRepository.save(category);

        assertNotNull(newCategory);
        assertEquals(newCategory.getType(),type);
        assertEquals(newCategory.getTitle(),title);

        log.info("category => {}",newCategory);
    }

    @Test
    public void read(){
        String type = "COMPUTER";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        optionalCategory.ifPresent(category -> {
            assertEquals(category.getType(),type);
            log.info("category => {}",category);
        });
    }
}