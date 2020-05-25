package com.poly.api.service;

import com.poly.api.dto.DistrictDto;
import com.poly.api.dto.ProvinceDto;
import com.poly.api.entities.Province;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface ProvinceService {
    List<Province> findAll();

    ProvinceDto findById(int id);

    ProvinceDto save(ProvinceDto provinceDto);

    ProvinceDto update(ProvinceDto provinceDto);
}
