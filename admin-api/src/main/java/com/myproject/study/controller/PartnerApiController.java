package com.myproject.study.controller;

import com.myproject.study.controller.CrudController;
import com.myproject.study.model.entity.Partner;
import com.myproject.study.model.network.request.PartnerApiRequest;
import com.myproject.study.model.network.response.PartnerApiResponse;
import com.myproject.study.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

    public PartnerApiController(BaseService<PartnerApiRequest, PartnerApiResponse, Partner> baseService) {
        super(baseService);
    }

}
