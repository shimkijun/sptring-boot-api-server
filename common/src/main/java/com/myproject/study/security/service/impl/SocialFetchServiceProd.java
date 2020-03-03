package com.myproject.study.security.service.impl;

import com.myproject.study.model.enumclass.SocialProviders;
import com.myproject.study.model.network.response.SocialLoginResponse;
import com.myproject.study.security.service.specification.SocialFetchService;
import com.myproject.study.security.social.SocialUserProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SocialFetchServiceProd implements SocialFetchService {

    private static final String HEADER_PREFIX = "Bearer ";

    @Override
    public SocialUserProperty getSocialUserProperty(SocialLoginResponse res) {

        SocialProviders provider = res.getProviders();
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<>("parameter",generateHeader(res.getToken()));

        return restTemplate.exchange(provider.getUserinfoEndpoint(), HttpMethod.GET, entity, provider.getPropertyMetaclass()).getBody();
    }

    private HttpHeaders generateHeader(String token){
        HttpHeaders headers = new HttpHeaders();

        headers.add("Authorization",generateHeaderContent(token));

        return headers;
    }

    private String generateHeaderContent(String token){
        StringBuilder sb = new StringBuilder();

        sb.append(HEADER_PREFIX);
        sb.append(token);

        return sb.toString();
    }
}
