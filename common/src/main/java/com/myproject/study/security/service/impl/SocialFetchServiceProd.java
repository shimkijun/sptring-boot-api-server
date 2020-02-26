package com.myproject.study.security.service.impl;

import com.myproject.study.model.network.response.SocialLoginResponse;
import com.myproject.study.security.service.specification.SocialFetchService;
import com.myproject.study.security.social.SocialUserProperty;
import org.springframework.stereotype.Service;

@Service
public class SocialFetchServiceProd implements SocialFetchService {

    @Override
    public SocialUserProperty socialUserProperty(SocialLoginResponse res) {
        return null;
    }
}
