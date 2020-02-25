package com.myproject.study.security.social;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KakaoUserProperty{

    @JsonProperty("kaccount_email_verified")
    private Boolean verified;

}
