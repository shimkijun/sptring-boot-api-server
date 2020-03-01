package com.myproject.study.security.service.impl;

import com.myproject.study.model.enumclass.SocialProviders;
import com.myproject.study.model.network.response.SocialLoginResponse;
import com.myproject.study.security.social.SocialUserProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class SocialFetchServiceProdTests {

    private  SocialFetchServiceProd prod = new SocialFetchServiceProd();
    private SocialLoginResponse res;

    @BeforeEach
    void setUp(){
        this.res = new SocialLoginResponse(SocialProviders.KAKAO,"L7QngXNfXhlZliqmJVftuN2f3sDLbpWd9oLoLwo9cxgAAAFwkDI_MQ");
    }

    @Test
    void restTemplate_Particel(){
        System.out.println(new RestTemplate().getForObject("http://www.naver.com",String.class));
    }

    @Test
    void service_fetchSocialInfo(){
        SocialUserProperty property = prod.getSocialUserProperty(this.res);

        System.out.println(property);
    }

}