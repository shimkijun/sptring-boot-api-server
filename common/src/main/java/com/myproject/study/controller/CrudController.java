package com.myproject.study.controller;

import com.myproject.study.ifs.CrudInterface;
import com.myproject.study.model.network.Header;
import com.myproject.study.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public abstract class CrudController<Req,Res,Entity> implements CrudInterface<Req,Res> {

    protected final BaseService<Req,Res,Entity> baseService;

    @Autowired(required = false)
    public CrudController(BaseService<Req, Res, Entity> baseService) {
        this.baseService = baseService;
    }

    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        return baseService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<Res> read(@PathVariable Long id) {
        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Res> update(@RequestBody Header<Req> request) {
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<Res> delete(@PathVariable Long id) {
        return baseService.delete(id);
    }
}
