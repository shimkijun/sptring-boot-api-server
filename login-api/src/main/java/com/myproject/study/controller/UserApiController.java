package com.myproject.study.controller;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.service.BaseService;
import com.myproject.study.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse, User>{

    public UserApiController(BaseService<UserApiRequest, UserApiResponse, User> baseService) {
        super(baseService);
    }

}
