package com.poly.api.service;

import com.poly.api.dto.DistrictDto;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface DistrictService {
    List<DistrictDto> findAll();

    DistrictDto findById(int id);

    DistrictDto save(DistrictDto districtDto);

    DistrictDto update(DistrictDto districtDto);
}
