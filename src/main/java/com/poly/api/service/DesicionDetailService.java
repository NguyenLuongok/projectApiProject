package com.poly.api.service;

import com.poly.api.dto.DesiciondetailDto;

import java.util.List;

public interface DesicionDetailService {

    List<DesiciondetailDto> findAll();

    List<DesiciondetailDto> findAllByDesicionId(int desicionDetailId);

    List<DesiciondetailDto> findAllByStudentId(int studentId);

    List<DesiciondetailDto> saveAll(List<DesiciondetailDto> desiciondetailDtos,int desicionId);

}
