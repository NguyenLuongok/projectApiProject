package com.poly.api.service;

import com.poly.api.dto.CampaignDto;
import com.poly.api.entities.Campaign;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface CampaignService {
    List<Campaign> findAll();

    CampaignDto findById(int id);

    CampaignDto save(CampaignDto campaignDto);

    CampaignDto update(CampaignDto campaignDto);
}
