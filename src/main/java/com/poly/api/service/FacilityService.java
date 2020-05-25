package com.poly.api.service;

import com.poly.api.dto.FacilityDto;
import com.poly.api.entities.Facility;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface FacilityService {
    List<Facility> findAll();

    FacilityDto findById(int id);

    FacilityDto save(FacilityDto facilityDto);

    FacilityDto update(FacilityDto facilityDto);
}
