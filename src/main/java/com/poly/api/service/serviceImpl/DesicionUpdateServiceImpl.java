package com.poly.api.service.serviceImpl;

import com.poly.api.dto.DesicionupdateDto;
import com.poly.api.entities.Decisionupdate;
import com.poly.api.entities.Desiciondetail;
import com.poly.api.repository.DesiciondetailRepository;
import com.poly.api.repository.DesicionupdateRepository;
import com.poly.api.service.DesicionUpdateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class DesicionUpdateServiceImpl implements DesicionUpdateService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DesicionupdateRepository desicionupdateRepository;

    @Autowired
    private DesiciondetailRepository desiciondetailRepository;

    @Override
    public List<DesicionupdateDto> findAll() {
        List<Decisionupdate> decisionupdates = desicionupdateRepository.findAll();
        List<DesicionupdateDto> decisionupdateDtos = new ArrayList<>();
        for (Decisionupdate decisionupdate: decisionupdates){
            decisionupdateDtos.add(new DesicionupdateDto(decisionupdate.getDecisionUpdateId(),decisionupdate.getNamePdf(),decisionupdate.getDesiciondetail().getDecisionDetailId()));
        }
        Type listType = new TypeToken<List<DesicionupdateDto>>(){}.getType();
        List<DesicionupdateDto> dtoList = modelMapper.map(decisionupdateDtos,listType);
        return dtoList;
    }

    @Override
    public DesicionupdateDto findById(int desicionUpdateId) {
        Decisionupdate decisionupdate = desicionupdateRepository.findById(desicionUpdateId).get();
        DesicionupdateDto desicionupdateDto = modelMapper.map(new DesicionupdateDto(decisionupdate.getDecisionUpdateId(),decisionupdate.getNamePdf(),decisionupdate.getDesiciondetail().getDecisionDetailId()),DesicionupdateDto.class);
        return desicionupdateDto;
    }

    @Override
    public List<DesicionupdateDto> findByDesicionDetail(int desicionDetailId) {
        List<Decisionupdate> decisionupdates = desicionupdateRepository.findAllByDesiciondetailId(desicionDetailId);
        if(decisionupdates == null){
            return null;
        }
        else {
            List<DesicionupdateDto> decisionupdateDtos = new ArrayList<>();
            for (Decisionupdate decisionupdate: decisionupdates){
                decisionupdateDtos.add(new DesicionupdateDto(decisionupdate.getDecisionUpdateId(),decisionupdate.getNamePdf(),decisionupdate.getDesiciondetail().getDecisionDetailId()));
            }
            Type listType = new TypeToken<List<DesicionupdateDto>>(){}.getType();
            List<DesicionupdateDto> dtoList = modelMapper.map(decisionupdateDtos,listType);
            return dtoList;
        }
    }

    @Override
    public DesicionupdateDto save(DesicionupdateDto desicionupdateDto) {
        Desiciondetail desiciondetail = desiciondetailRepository.findById(desicionupdateDto.getDesiciondetailId()).get();
        if(desiciondetail != null){
            Decisionupdate decisionupdate = modelMapper.map(new Decisionupdate(desicionupdateDto.getNamePdf(),desiciondetail),Decisionupdate.class);
            desicionupdateRepository.save(decisionupdate);
        }
        return desicionupdateDto;
    }

    @Override
    public DesicionupdateDto update(DesicionupdateDto desicionupdateDto) {
        Desiciondetail desiciondetail = desiciondetailRepository.findById(desicionupdateDto.getDesiciondetailId()).get();
        if(desiciondetail != null){
            Decisionupdate decisionupdate = modelMapper.map(new Decisionupdate(desicionupdateDto.getDecisionUpdateId(),desicionupdateDto.getNamePdf(),desiciondetail),Decisionupdate.class);
            desicionupdateRepository.save(decisionupdate);
        }
        return desicionupdateDto;
    }
}
