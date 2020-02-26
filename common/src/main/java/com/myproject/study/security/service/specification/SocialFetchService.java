package com.myproject.study.security.service.specification;

import com.myproject.study.model.network.response.SocialLoginResponse;
import com.myproject.study.security.social.SocialUserProperty;

public interface SocialFetchService {

    SocialUserProperty socialUserProperty(SocialLoginResponse res);
}
