package com.poly.api.service;

import com.poly.api.dto.DesicionupdateDto;
import com.poly.api.entities.Decisionupdate;

import java.util.List;

public interface DesicionUpdateService {

    List<DesicionupdateDto> findAll();

    DesicionupdateDto findById(int desicionUpdateId);

    List<DesicionupdateDto> findByDesicionDetail(int desicionDetailId);

    DesicionupdateDto save(DesicionupdateDto desicionupdateDto);

    DesicionupdateDto update(DesicionupdateDto desicionupdateDto);
}
