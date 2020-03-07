package com.myproject.study.controller;

import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.service.BaseService;
import com.myproject.study.service.UserApiLogicService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse, User>{

    private final UserApiLogicService userApiLogicService;

    public UserApiController(BaseService<UserApiRequest, UserApiResponse, User> baseService, UserApiLogicService userApiLogicService) {
        super(baseService);
        this.userApiLogicService = userApiLogicService;
    }

    @PostMapping("/lookup")
    public Header<UserApiResponse> lookupEmail(@RequestBody UserApiRequest request) {
        return userApiLogicService.lookup(request);
    }

}
