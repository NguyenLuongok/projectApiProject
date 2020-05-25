package com.poly.api.service.serviceImpl;

import com.poly.api.dto.DesiciondetailDto;
import com.poly.api.entities.Desicion;
import com.poly.api.entities.Desiciondetail;
import com.poly.api.entities.Student;
import com.poly.api.repository.DesicionRepository;
import com.poly.api.repository.DesiciondetailRepository;
import com.poly.api.repository.StudentRepository;
import com.poly.api.service.DesicionDetailService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class DesiciondetailServiceImpl implements DesicionDetailService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DesiciondetailRepository desiciondetailRepository;

    @Autowired
    private DesicionRepository desicionRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<DesiciondetailDto> findAll() {
        List<Desiciondetail> desiciondetails = desiciondetailRepository.findAll();
        List<DesiciondetailDto> desiciondetailDtos = new ArrayList<>();
        for(Desiciondetail desiciondetail : desiciondetails){
            desiciondetailDtos.add(new DesiciondetailDto(desiciondetail.getDecisionDetailId(),desiciondetail.getFolderDesicion(),desiciondetail.getDesicion().getDecisionId(),
                    desiciondetail.getDesicion().getDecisionName(),desiciondetail.getStudent().getStudentId(),desiciondetail.getStudent().getEmail()));
        }
        Type listType = new TypeToken<List<DesiciondetailDto>>(){}.getType();
        List<DesiciondetailDto> desiciondetailDtoList = modelMapper.map(desiciondetailDtos,listType);
        return desiciondetailDtoList;
    }

    @Override
    public List<DesiciondetailDto> findAllByDesicionId(int desicionDetailId) {
        List<Desiciondetail> desiciondetails = desiciondetailRepository.findAllByDesicionId(desicionDetailId);
        List<DesiciondetailDto> desiciondetailDtos = new ArrayList<>();
        for(Desiciondetail desiciondetail : desiciondetails){
            desiciondetailDtos.add(new DesiciondetailDto(desiciondetail.getDecisionDetailId(),desiciondetail.getFolderDesicion(),desiciondetail.getDesicion().getDecisionId(),
                    desiciondetail.getDesicion().getDecisionName(),desiciondetail.getStudent().getStudentId(),desiciondetail.getStudent().getEmail()));
        }
        Type listType = new TypeToken<List<DesiciondetailDto>>(){}.getType();
        List<DesiciondetailDto> desiciondetailDtoList = modelMapper.map(desiciondetailDtos,listType);
        return desiciondetailDtoList;
    }

    @Override
     public List<DesiciondetailDto> findAllByStudentId(int studentId) {
        List<Desiciondetail> desiciondetails = desiciondetailRepository.findAllByStudentId(studentId);
        List<DesiciondetailDto> desiciondetailDtos = new ArrayList<>();
        for(Desiciondetail desiciondetail : desiciondetails){
            desiciondetailDtos.add(new DesiciondetailDto(desiciondetail.getDecisionDetailId(),desiciondetail.getFolderDesicion(),desiciondetail.getDesicion().getDecisionId(),
                    desiciondetail.getDesicion().getDecisionName(),desiciondetail.getStudent().getStudentId(),desiciondetail.getStudent().getEmail()));
        }
        Type listType = new TypeToken<List<DesiciondetailDto>>(){}.getType();
        List<DesiciondetailDto> desiciondetailDtoList = modelMapper.map(desiciondetailDtos,listType);
        return desiciondetailDtoList;
    }

    @Override
    public List<DesiciondetailDto> saveAll(List<DesiciondetailDto> desiciondetailDtos, int desicionId) {
        Desicion desicion = desicionRepository.findById(desicionId).get();
        if(desicion !=null){
            for(DesiciondetailDto desiciondetailDto : desiciondetailDtos){
                Student student  = studentRepository.findById(desiciondetailDto.getStudentId()).get();
                Desiciondetail desiciondetail = modelMapper.map(new Desiciondetail(desiciondetailDto.getFolderDesicion(),desicion,student),Desiciondetail.class);
                desiciondetailRepository.save(desiciondetail);
            }
        }
        return findAllByDesicionId(desicionId);
    }

}
