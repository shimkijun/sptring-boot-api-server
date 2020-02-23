package com.myproject.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

    ADMIN(0, "ADMIN","관리자"),
    USER(1,"USER","일반 사용자");

    private Integer id;

    private String title;

    private String description;

}
