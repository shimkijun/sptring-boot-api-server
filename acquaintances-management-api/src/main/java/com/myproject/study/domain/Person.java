package com.myproject.study.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"phoneNumber"})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    @NonNull
    private String bloodType;

    private String hobby;

    private String address;

    private LocalDate birthday;

    private String job;

    private String phoneNumber;

    @OneToOne
    private Block block;

}
