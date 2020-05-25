package com.poly.api.service.serviceImpl;

import com.poly.api.dto.CampaigndetailDto;
import com.poly.api.entities.Campaign;
import com.poly.api.entities.Campaigndetail;
import com.poly.api.entities.Facility;
import com.poly.api.repository.CampaignRepository;
import com.poly.api.repository.CampaigndetailRepository;
import com.poly.api.repository.FacilityRepository;
import com.poly.api.service.CampaigndetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public class CampaigndetailServiceImpl implements CampaigndetailService {
    @Autowired
    private CampaigndetailRepository campaigndetailRepository;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CampaigndetailDto> findAll() {
        List<Campaigndetail> campaigndetails = campaigndetailRepository.findAll();
        List<CampaigndetailDto> campaigndetailDtos = new ArrayList<>();
        if (campaigndetails != null) {
            for (Campaigndetail campaigndetail : campaigndetails) {
                CampaigndetailDto campaigndetailDto = new CampaigndetailDto(campaigndetail.getCampaignDetailId(), campaigndetail.getCampaign().getCampaignId(), campaigndetail.getFacility().getFacilityId());
                campaigndetailDtos.add(campaigndetailDto);
            }
            return campaigndetailDtos;
        }
        return null;
    }

    @Override
    public CampaigndetailDto findById(int id) {
        Campaigndetail campaigndetail = campaigndetailRepository.findById(id).get();
        if (campaigndetail != null) {
            CampaigndetailDto campaigndetailDto = new CampaigndetailDto(campaigndetail.getCampaignDetailId(), campaigndetail.getCampaign().getCampaignId(), campaigndetail.getFacility().getFacilityId());
            return campaigndetailDto;
        }
        return null;
    }

    @Override
    public CampaigndetailDto save(CampaigndetailDto campaigndetailDto) {
        Campaign campaign = campaignRepository.findByCampaignId(campaigndetailDto.getCampaignId());
        Facility facility = facilityRepository.findById(campaigndetailDto.getFacilityId()).get();
        if (campaigndetailDto != null) {
            Campaigndetail campaigndetail = modelMapper.map(new Campaigndetail(campaigndetailDto.getCampaignDetailId(), campaign, facility), Campaigndetail.class);
            campaigndetailRepository.save(campaigndetail);
            return campaigndetailDto;
        }
        return null;
    }

    @Override
    public CampaigndetailDto update(CampaigndetailDto campaigndetailDto) {
        Campaign campaign = campaignRepository.findByCampaignId(campaigndetailDto.getCampaignId());
        Facility facility = facilityRepository.findById(campaigndetailDto.getFacilityId()).get();
        Campaigndetail campaigndetail = campaigndetailRepository.findById(campaigndetailDto.getCampaignDetailId()).get();
        if (campaigndetail != null) {
            campaigndetail = modelMapper.map(new Campaigndetail(campaign, facility), Campaigndetail.class);
            campaigndetailRepository.save(campaigndetail);
            return campaigndetailDto;
        }
        return null;
    }
}
