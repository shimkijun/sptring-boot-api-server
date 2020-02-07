package com.myproject.study.controller.api;

import com.myproject.study.controller.CrudController;
import com.myproject.study.model.entity.User;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.UserApiRequest;
import com.myproject.study.model.network.response.UserApiResponse;
import com.myproject.study.model.network.response.UserOrderInfoApiResponse;
import com.myproject.study.service.BaseService;
import com.myproject.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/admin/user")
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse, User> {

    private final UserApiLogicService userApiLogicService;

    public UserApiController(BaseService<UserApiRequest, UserApiResponse, User> baseService,
                             UserApiLogicService userApiLogicService) {
        super(baseService);
        this.userApiLogicService = userApiLogicService;
    }


    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }

    @GetMapping("")
    public Header<List<UserApiResponse>> search
            (
                    @PageableDefault(
                            sort = "id",direction = Sort.Direction.DESC, size = 15
                    ) Pageable pageable
            )
    {
        log.info("{}",pageable);
        return userApiLogicService.search(pageable);
    }

}
