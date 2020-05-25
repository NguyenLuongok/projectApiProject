package com.poly.api.service.serviceImpl;

import com.poly.api.dto.FacilityDto;
import com.poly.api.entities.Facility;
import com.poly.api.repository.FacilityRepository;
import com.poly.api.service.FacilityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Facility> findAll() {
        List<Facility> facilities = new ArrayList<>();
        facilityRepository.findAll().forEach(facilities::add);
        return facilities;
    }

    @Override
    public FacilityDto findById(int id) {
        Facility facility = facilityRepository.findById(id).get();
        if (facility != null) {
            FacilityDto facilityDto = new FacilityDto(facility.getFacilityId(), facility.getFacilityName());
            return facilityDto;
        }
        return null;
    }

    @Override
    public FacilityDto save(FacilityDto facilityDto) {
        if (facilityDto != null) {
            Facility facility = modelMapper.map(new Facility(facilityDto.getFacilityId(), facilityDto.getFacilityName()), Facility.class);
            facilityRepository.save(facility);
            return facilityDto;
        }
        return null;
    }

    @Override
    public FacilityDto update(FacilityDto facilityDto) {
        Facility facility = facilityRepository.findById(facilityDto.getFacilityId()).get();
        if (facility != null) {
            facility = modelMapper.map(new Facility(facilityDto.getFacilityName()), Facility.class);
            facilityRepository.save(facility);
            return facilityDto;
        }
        return null;
    }
}
