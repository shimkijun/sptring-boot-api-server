package com.myproject.study.security.social;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class KakaoUserProperty implements SocialUserProperty{

    // TODO: 카카오에서 제공해주는 JSON 형태로 나중에 변경

    @JsonProperty("kaccount_email_verified")
    private Boolean verified;

    @JsonProperty("id")
    private Long userUniqueId;

    @JsonProperty("properties")
    private Map<String,String> userProperties;

    @Override
    public String getUserId() {
        return userUniqueId.toString();
    }

    @Override
    public String getUserNickname() {
        return userProperties.get("nickname");
    }

    @Override
    public String getProfileHref() {
        return userProperties.get("profile_image");
    }
}
