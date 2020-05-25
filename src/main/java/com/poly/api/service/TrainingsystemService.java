package com.poly.api.service;

import com.poly.api.dto.SpecializedDto;
import com.poly.api.dto.TrainingsystemDto;
import com.poly.api.entities.Specialized;
import com.poly.api.entities.Trainingsystem;

import java.util.List;

/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface TrainingsystemService {
    List<Trainingsystem> findAll();

    TrainingsystemDto findById(int id);

    TrainingsystemDto findByName(String name);

    TrainingsystemDto save(TrainingsystemDto trainingsystemDto);

    TrainingsystemDto update(TrainingsystemDto trainingsystemDto);
}
