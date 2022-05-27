package com.example.springweb.Service;

import com.example.springweb.dto.UserDto;
import com.example.springweb.entity.UserEntity;

import java.util.List;

public interface IUserService {

    UserDto findUserByName(String userName);
    List<UserDto>findAll();
    void DeleteById(Long id);

    UserEntity findUserByEmail(String email);

    UserEntity findUserByToken(String token);
}
