package com.myproject.study.model.network.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenResponse {

    @JsonProperty("token")
    private String token;

}
