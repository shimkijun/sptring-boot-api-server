package com.myproject.study.model.network.response;

import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {

    private Long id;

    private String email;

    private String nickname;

    private UserStatus status;

    private UserRole userRole;

}
