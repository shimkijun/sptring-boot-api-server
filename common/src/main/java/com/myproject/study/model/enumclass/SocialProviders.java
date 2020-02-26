package com.myproject.study.model.enumclass;

import com.fasterxml.jackson.annotation.JsonValue;
import com.myproject.study.security.social.KakaoUserProperty;
import com.myproject.study.security.social.SocialUserProperty;
import lombok.Getter;

@Getter
public enum SocialProviders {

    KAKAO("https://kapi.kakao.com/v2/user/me", KakaoUserProperty.class);

    private String userInfoEndpoint;
    private Class<? extends SocialUserProperty> propertyMetaClass;

    SocialProviders(String userInfoEndpoint, Class<? extends SocialUserProperty> propertyMetaClass){
        this.userInfoEndpoint = userInfoEndpoint;
        this.propertyMetaClass = propertyMetaClass;
    }

    @JsonValue
    public String getProviderName(){
        return this.name();
    }

}
