package com.myproject.study.model.network.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountApiRequest {

    @JsonProperty
    private String userId;

    @JsonProperty
    private String password;

}
