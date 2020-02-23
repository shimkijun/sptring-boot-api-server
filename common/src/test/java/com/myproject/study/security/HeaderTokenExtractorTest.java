package com.myproject.study.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTokenExtractorTest {

    private HeaderTokenExtractor extractor = new HeaderTokenExtractor();
    private String header;

    @BeforeEach
    void setUp(){
        this.header = "Bearer asdfsdaffsda.fsdafsdgsdfa.fsdagfghtereq";
    }

    @Test
    void TEST_JWT_EXTRACT(){
        assertEquals(extractor.extract(this.header),"asdfsdaffsda.fsdafsdgsdfa.fsdagfghtereq");
    }


}