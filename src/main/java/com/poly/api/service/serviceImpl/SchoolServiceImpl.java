package com.poly.api.service.serviceImpl;

import com.poly.api.dto.SchoolDto;
import com.poly.api.entities.School;
import com.poly.api.repository.SchoolRepository;
import com.poly.api.service.SchoolService;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<SchoolDto> findAll() {
        List<School> schools = schoolRepository.findAll();
        List<SchoolDto> schoolDtos = new ArrayList<>();
        if (schools != null) {
            for (School school : schools) {
                SchoolDto schoolDto = new SchoolDto(school.getSchoolId(), school.getSchoolName());
                schoolDtos.add(schoolDto);
            }
            return schoolDtos;
        }
        return null;
    }

    /**
     * Ở đây School không phụ thuộc khóa nào nên ko chuyển sang đối tượng truyền dữ liệu(Dto) nữa. Vì ngại :v
     */
//    @Override
//    public List<School> findAll() {
//        List<School> schools = new ArrayList<>();
//        schoolRepository.findAll().forEach(schools::add);
//        return schools;
//    }


    @Override
    public SchoolDto findById(int id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()) {
            School school1 = school.get();
            SchoolDto schoolDto = new SchoolDto(school1.getSchoolId(), school1.getSchoolName());
            return schoolDto;
        }
        return null;
    }


    @Override
    public SchoolDto findByName(String name) {
        return null;
    }

    @Override
    public SchoolDto save(SchoolDto schoolDto) {
        if (schoolDto != null) {
            School school = modelMapper.map(new School(schoolDto.getSchoolId(), schoolDto.getSchoolName()), School.class);
            schoolRepository.save(school);
            return schoolDto;
        }
        return null;
    }

    @Override
    public SchoolDto update(SchoolDto schoolDto) {
        Optional<School> school = schoolRepository.findById(schoolDto.getSchoolId());
        if (school.isPresent()) {
            School school1 = school.get();
            school1 = modelMapper.map(new School(schoolDto.getSchoolName()), School.class);
            schoolRepository.save(school1);
            return schoolDto;
        }
        return null;
    }
}
