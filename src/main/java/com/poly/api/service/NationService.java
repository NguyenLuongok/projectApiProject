package com.poly.api.service;

import com.poly.api.dto.NationDto;
import com.poly.api.dto.SchoolDto;
import com.poly.api.entities.Nation;
import com.poly.api.entities.School;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface NationService {
    List<Nation> findAll();

    NationDto findById(int id);

    NationDto save(NationDto nationDto);

    NationDto update(NationDto nationDto);
}
