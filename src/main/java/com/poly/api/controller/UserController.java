package com.poly.api.controller;


import com.poly.api.dto.UserDto;
import com.poly.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(produces = "application/json")
    public List<UserDto> getAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public UserDto getById(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @PostMapping(produces = "application/json")
    public UserDto save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @PutMapping(produces = "application/json")
    public UserDto update(@RequestBody UserDto userDto){
        return userService.update(userDto);
    }
}
