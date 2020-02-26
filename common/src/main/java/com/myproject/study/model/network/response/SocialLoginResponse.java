package com.myproject.study.model.network.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.study.model.enumclass.SocialProviders;
import lombok.Data;

@Data
public class SocialLoginResponse {

    @JsonProperty("provider")
    private SocialProviders providers;

    @JsonProperty("token")
    private String token;

}
