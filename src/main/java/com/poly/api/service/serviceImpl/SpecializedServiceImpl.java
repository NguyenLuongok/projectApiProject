package com.poly.api.service.serviceImpl;

import com.poly.api.dto.SpecializedDto;
import com.poly.api.entities.Specialized;
import com.poly.api.repository.SpecializedRepository;
import com.poly.api.service.SpecializedService;
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
public class SpecializedServiceImpl implements SpecializedService {
    @Autowired
    private SpecializedRepository specializedRepository;
    @Autowired
    ModelMapper modelMapper;


    //Bang nay khong chuyen sang dto
    @Override
    public List<SpecializedDto> findAll() {
        List<Specialized> specializeds = specializedRepository.findAll();
        List<SpecializedDto> specializedDtos = new ArrayList<>();
        if (specializeds != null) {
            for (Specialized specialized : specializeds) {
                SpecializedDto specializedDto = new SpecializedDto(specialized.getSpecializedId(), specialized.getSpecializedName());
                specializedDtos.add(specializedDto);
            }
            return specializedDtos;
        }
        return null;
    }

    @Override
    public SpecializedDto findById(int id) {
        Specialized specialized = specializedRepository.findById(id).get();
        if (specialized != null) {
            SpecializedDto specializedDto = new SpecializedDto(specialized.getSpecializedId(), specialized.getSpecializedName());
            return specializedDto;
        }
        return null;
    }

    @Override
    public SpecializedDto findByName(String name) {
        return null;
    }

    @Override
    public SpecializedDto save(SpecializedDto specializedDto) {
        if (specializedDto != null) {
            Specialized specialized = modelMapper.map(new Specialized(specializedDto.getSpecializedId(), specializedDto.getSpecializedName()), Specialized.class);
            specializedRepository.save(specialized);
            return specializedDto;
        }
        return null;
    }

    @Override
    public SpecializedDto update(SpecializedDto specializedDto) {
        Specialized specialized = specializedRepository.findById(specializedDto.getSpecializedId()).get();
        if (specialized != null) {
            specialized = modelMapper.map(new Specialized(specializedDto.getSpecializedName()), Specialized.class);
            specializedRepository.save(specialized);
        }
        return null;
    }
}
