package com.poly.api.service;

import com.poly.api.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto>  findAll();

    UserDto findById(int id);

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

}
