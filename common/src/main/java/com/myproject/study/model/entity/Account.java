package com.myproject.study.model.entity;


import com.myproject.study.model.enumclass.SocialProviders;
import com.myproject.study.model.enumclass.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String userId;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    private Long socialId;

    @Enumerated(value = EnumType.STRING)
    private SocialProviders socialProviders;

    private String socialProfilePic;


}
