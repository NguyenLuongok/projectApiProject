package com.poly.api.service.serviceImpl;

import com.poly.api.dto.TrainingsystemDto;
import com.poly.api.entities.Trainingsystem;
import com.poly.api.repository.TrainingsystemRepository;
import com.poly.api.service.TrainingsystemService;
import net.bytebuddy.asm.Advice;
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
public class    TrainingsystemServiceImpl implements TrainingsystemService {
    @Autowired
    private TrainingsystemRepository trainingsystemRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Trainingsystem> findAll() {
        List<Trainingsystem> trainingsystems = new ArrayList<>();
        trainingsystemRepository.findAll().forEach(trainingsystems::add);
        return trainingsystems;
    }

    @Override
    public TrainingsystemDto findById(int id) {
        Trainingsystem trainingsystem = trainingsystemRepository.findById(id).get();
        if (trainingsystem != null) {
            TrainingsystemDto trainingsystemDto = new TrainingsystemDto(trainingsystem.getTrainingSystemId(), trainingsystem.getTrainingSystemName());
            return trainingsystemDto;
        }
        return null;
    }

    @Override
    public TrainingsystemDto findByName(String name) {
        Trainingsystem trainingsystem = trainingsystemRepository.findByTrainingSystemName(name);
        return null;
    }

    @Override
    public TrainingsystemDto save(TrainingsystemDto trainingsystemDto) {
        if (trainingsystemDto != null) {
            Trainingsystem trainingsystem = modelMapper.map(new Trainingsystem(trainingsystemDto.getTrainingSystemId(), trainingsystemDto.getTrainingSystemName()), Trainingsystem.class);
            trainingsystemRepository.save(trainingsystem);
            return trainingsystemDto;
        }
        return null;
    }

    @Override
    public TrainingsystemDto update(TrainingsystemDto trainingsystemDto) {
        Trainingsystem trainingsystem = trainingsystemRepository.findById(trainingsystemDto.getTrainingSystemId()).get();
        if (trainingsystem != null) {
            trainingsystem = modelMapper.map(new Trainingsystem(trainingsystemDto.getTrainingSystemName()), Trainingsystem.class);
            trainingsystemRepository.save(trainingsystem);
            return trainingsystemDto;
        }
        return null;
    }

}
