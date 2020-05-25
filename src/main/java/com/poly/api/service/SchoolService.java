package com.poly.api.service;

import com.poly.api.dto.SchoolDto;
import com.poly.api.entities.School;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface SchoolService {
//    List<SchoolDto> findAll();

    List<SchoolDto> findAll();

    SchoolDto findById(int id);

    SchoolDto findByName(String name);

    SchoolDto save(SchoolDto schoolDto);

    SchoolDto update(SchoolDto schoolDto);

}
