package com.myproject.study.model.network.request;

import com.myproject.study.model.enumclass.UserRole;
import com.myproject.study.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiRequest {

    private Long id;

    private String email;

    private String password;

    private String nickname;

    private UserStatus status;

    private UserRole role;

}
