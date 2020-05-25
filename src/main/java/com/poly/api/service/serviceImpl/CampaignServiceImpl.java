package com.poly.api.service.serviceImpl;

import com.poly.api.dto.CampaignDto;
import com.poly.api.entities.Campaign;
import com.poly.api.repository.CampaignRepository;
import com.poly.api.repository.CampaigndetailRepository;
import com.poly.api.service.CampaignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Service
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Campaign> findAll() {
        List<Campaign> campaigns = new ArrayList<>();
        campaignRepository.findAll().forEach(campaigns::add);
        return campaigns;
    }

    @Override
    public CampaignDto findById(int id) {
        Campaign campaign = campaignRepository.findById(id).get();
        if (campaign != null) {
            CampaignDto campaignDto = new CampaignDto(campaign.getCampaignId(), campaign.getCampaignName());
            return campaignDto;
        }
        return null;
    }

    @Override
    public CampaignDto save(CampaignDto campaignDto) {
        if (campaignDto != null) {
            Campaign campaign = modelMapper.map(new Campaign(campaignDto.getCampaignId(), campaignDto.getCampaignName()), Campaign.class);
            campaignRepository.save(campaign);
            return campaignDto;
        }
        return null;
    }

    @Override
    public CampaignDto update(CampaignDto campaignDto) {
        Campaign campaign = campaignRepository.findById(campaignDto.getCampaignId()).get();
        if (campaign != null) {
            campaign = modelMapper.map(new Campaign(campaignDto.getCampaignName()), Campaign.class);
            campaignRepository.save(campaign);
            return campaignDto;
        }
        return null;
    }
}
