package com.myproject.study.service;

import com.myproject.study.ifs.CrudInterface;
import com.myproject.study.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class BaseService<Req,Res,Entity> implements CrudInterface<Req,Res> {

    protected final JpaRepository<Entity,Long> baseRepository;

}
