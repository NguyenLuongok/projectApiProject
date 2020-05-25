package com.poly.api.service.serviceImpl;

import com.poly.api.dto.DesicionDto;
import com.poly.api.entities.Desicion;
import com.poly.api.repository.DesicionRepository;
import com.poly.api.repository.repositoryImpl.DesicionRepositoryImpl;
import com.poly.api.service.DesicionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesicionServiceImpl implements DesicionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DesicionRepository desicionRepository;

    @Autowired
    private DesicionRepositoryImpl desicionRepositoryImpl;

    @Override
    public List<Desicion> findAll() {
        List<Desicion> desicions = new ArrayList<>();
        desicionRepository.findAll().forEach(desicions::add);
        return desicions;
    }

    @Override
    public DesicionDto findById(int id) {
        Desicion desicion = desicionRepository.findById(id).get();
        DesicionDto desicionDto = null;
        if(desicion != null){
            desicionDto = modelMapper.map(desicion,DesicionDto.class);
        }
        return desicionDto;
    }

    @Override
    public DesicionDto save(DesicionDto desicionDto) {
        Desicion desicion = modelMapper.map(desicionDto,Desicion.class);
        desicionRepositoryImpl.save(desicion);
        return desicionDto;
    }

    @Override
    public DesicionDto update(DesicionDto desicionDto) {
        Desicion desicion = modelMapper.map(desicionDto,Desicion.class);
        desicion.setDecisionId(desicionDto.getDecisionId());
        desicionRepository.save(desicion);
        return desicionDto;
    }
}
