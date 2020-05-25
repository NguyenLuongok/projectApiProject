package com.poly.api.service.serviceImpl;

import com.poly.api.dto.ProvinceDto;
import com.poly.api.entities.Province;
import com.poly.api.repository.ProvinceRepository;
import com.poly.api.service.ProvinceService;
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
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Province> findAll() {
        List<Province> provinces = new ArrayList<>();
        provinceRepository.findAll().forEach(provinces::add);
        return provinces;
    }

    @Override
    public ProvinceDto findById(int id) {
        Province province = provinceRepository.findById(id).get();
        if (province != null) {
            ProvinceDto provinceDto = new ProvinceDto(province.getProvinceId(), province.getProvinceName());
            return provinceDto;
        }
        return null;
    }

    @Override
    public ProvinceDto save(ProvinceDto provinceDto) {
        if (provinceDto != null) {
            Province province = modelMapper.map(new Province(provinceDto.getProvinceId(), provinceDto.getProvinceName()), Province.class);
            provinceRepository.save(province);
            return provinceDto;
        }
        return null;
    }

    @Override
    public ProvinceDto update(ProvinceDto provinceDto) {
        Province province = provinceRepository.findById(provinceDto.getProvinceId()).get();
        if (province != null) {
            province = modelMapper.map(new Province(provinceDto.getProvinceName()), Province.class);
            provinceRepository.save(province);
            return provinceDto;
        }
        return null;
    }
}
