package com.myproject.study.controller.api;

import com.myproject.study.controller.CrudController;
import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.service.BaseService;
import com.myproject.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/customer/signup")
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse, User> {

    private final UserApiLogicService userApiLogicService;

    public UserApiController(BaseService<UserApiRequest, UserApiResponse, User> baseService,
                             UserApiLogicService userApiLogicService) {
        super(baseService);
        this.userApiLogicService = userApiLogicService;
    }
}
