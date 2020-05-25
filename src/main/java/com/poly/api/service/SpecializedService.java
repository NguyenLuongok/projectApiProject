package com.poly.api.service;

import com.poly.api.dto.SpecializedDto;
import com.poly.api.entities.Specialized;

import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface SpecializedService {
    List<Specialized> findAll();

    SpecializedDto findById(int id);

    SpecializedDto findByName(String name);

    SpecializedDto save(SpecializedDto schoolDto);

    SpecializedDto update(SpecializedDto schoolDto);
}
