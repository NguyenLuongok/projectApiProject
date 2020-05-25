package com.poly.api.service;

import com.poly.api.dto.DesicionDto;
import com.poly.api.entities.Desicion;

import java.util.List;

public interface DesicionService {

    List<DesicionDto> findAll();

    DesicionDto findById(int id);

    DesicionDto save(DesicionDto desicionDto);

    DesicionDto update(DesicionDto desicionDto);
}
