package com.poly.api.controller;

import com.poly.api.dto.StudentDto;
import com.poly.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<StudentDto> getAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable int id){
        return  studentService.findById(id);
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto studentDto){
        return studentService.save(studentDto);
    }

    @PutMapping
    public StudentDto update(@RequestBody StudentDto studentDto){
        return studentService.update(studentDto);
    }
}
