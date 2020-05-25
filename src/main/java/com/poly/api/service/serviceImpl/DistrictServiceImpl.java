package com.poly.api.service.serviceImpl;

import com.poly.api.dto.DistrictDto;
import com.poly.api.entities.District;
import com.poly.api.entities.Province;
import com.poly.api.repository.DistrictRepository;
import com.poly.api.repository.ProvinceRepository;
import com.poly.api.service.DistrictService;
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
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<DistrictDto> findAll() {
        List<District> districts = districtRepository.findAll();
        List<DistrictDto> districtDtos = new ArrayList<>();
        if (districts != null) {
            for (District district : districts) {
                DistrictDto districtDto = new DistrictDto(district.getDistrictId(), district.getDistrictName(), district.getProvince().getProvinceId());
                districtDtos.add(districtDto);
            }
            return districtDtos;
        }
        return null;
    }

    @Override
    public DistrictDto findById(int id) {
        District district = districtRepository.findById(id).get();
        if (district != null) {
            DistrictDto districtDto = new DistrictDto(district.getDistrictId(), district.getDistrictName(), district.getProvince().getProvinceId());
            return districtDto;
        }
        return null;
    }

    @Override
    public DistrictDto save(DistrictDto districtDto) {
        Province province = provinceRepository.findById(districtDto.getProvinceId()).get();
        if (districtDto != null) {
            District district = modelMapper.map(new District(districtDto.getDistrictId(), districtDto.getDistrictName(), province), District.class);
            districtRepository.save(district);
            return districtDto;
        }
        return null;
    }

    @Override
    public DistrictDto update(DistrictDto districtDto) {
        District district = districtRepository.findById(districtDto.getDistrictId()).get();
        Province province = provinceRepository.findById(districtDto.getProvinceId()).get();
        if (district != null) {
            district = modelMapper.map(new District(districtDto.getDistrictName(), province), District.class);
            districtRepository.save(district);
            return districtDto;
        }
        return null;
    }
}
