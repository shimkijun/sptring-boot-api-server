package com.myproject.study.model.network.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.study.model.enumclass.SocialProviders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialLoginResponse {

    @JsonProperty("provider")
    private SocialProviders providers;

    @JsonProperty("token")
    private String token;

}
