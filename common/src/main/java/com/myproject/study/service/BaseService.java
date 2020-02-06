package com.myproject.study.service;

import com.myproject.study.ifs.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseService<Req,Res,Entity> implements CrudInterface<Req,Res> {

    protected final JpaRepository<Entity,Long> baseRepository;

    @Autowired(required = false)
    public BaseService(JpaRepository<Entity, Long> baseRepository) {
        this.baseRepository = baseRepository;
    }

}
