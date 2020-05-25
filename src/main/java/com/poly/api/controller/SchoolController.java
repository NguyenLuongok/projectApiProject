package com.poly.api.controller;

import com.poly.api.dto.SchoolDto;
import com.poly.api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {


    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<SchoolDto>> getAll(){
        try{
            List<SchoolDto> schools = schoolService.findAll();
            return new ResponseEntity<List<SchoolDto>>(schools, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
