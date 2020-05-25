package com.poly.api.service;

import com.poly.api.dto.CampaigndetailDto;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface CampaigndetailService {
    List<CampaigndetailDto> findAll();

    CampaigndetailDto findById(int id);

    CampaigndetailDto save(CampaigndetailDto campaigndetailDto);

    CampaigndetailDto update(CampaigndetailDto campaigndetailDto);
}
