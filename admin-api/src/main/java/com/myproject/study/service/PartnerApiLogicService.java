package com.myproject.study.service;

import com.myproject.study.model.entity.Partner;
import com.myproject.study.model.network.Header;
import com.myproject.study.model.network.request.PartnerApiRequest;
import com.myproject.study.model.network.response.PartnerApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest,PartnerApiResponse, Partner> {

    public PartnerApiLogicService(JpaRepository<Partner, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Header<PartnerApiResponse> create(PartnerApiRequest request) {
        return null;
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(partner -> response(partner))
                .orElseGet(() -> Header.ERROR("데이터없음"));
    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
        return null;
    }

    @Override
    public Header<PartnerApiResponse> delete(Long id) {
        return null;
    }

    public Header<PartnerApiResponse> response(Partner partner) {

        PartnerApiResponse body = PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .callCenter(partner.getCallCenter())
                .businessNumber(partner.getBusinessNumber())
                .address(partner.getAddress())
                .ceoName(partner.getCeoName())
                .partnerNumber(partner.getPartnerNumber())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .categoryId(partner.getId())
                .build();

        return Header.OK(body);
    }
}
