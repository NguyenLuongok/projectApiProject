package com.poly.api.service.serviceImpl;

import com.poly.api.dto.NationDto;
import com.poly.api.entities.Nation;
import com.poly.api.repository.NationRepository;
import com.poly.api.service.NationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Nation> findAll() {
        List<Nation> nations = new ArrayList<>();
        nationRepository.findAll().forEach(nations::add);
        return nations;
    }

    @Override
    public NationDto findById(int id) {
        Nation nation = nationRepository.findById(id).get();
        if (nation != null) {
            NationDto nationDto = new NationDto(nation.getNationId(), nation.getNationName());
            return nationDto;
        }
        return null;
    }

    @Override
    public NationDto save(NationDto nationDto) {
        if (nationDto != null) {
            Nation nation = modelMapper.map(new Nation(nationDto.getNationId(), nationDto.getNationName()), Nation.class);
            nationRepository.save(nation);
            return nationDto;
        }
        return null;
    }

    @Override
    public NationDto update(NationDto nationDto) {
        Nation nation = nationRepository.findById(nationDto.getNationId()).get();
        if (nation != null) {
            nation = modelMapper.map(new Nation(nationDto.getNationName()), Nation.class);
            nationRepository.save(nation);
            return nationDto;
        }
        return null;
    }
}
