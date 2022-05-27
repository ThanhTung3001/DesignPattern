package com.example.springweb.Service.imp;

import com.example.springweb.ConvertDto.ConvertDto;
import com.example.springweb.Reponsitory.IUserReponsitory;
import com.example.springweb.Service.IUserService;
import com.example.springweb.dto.CostumerUserDeital;
import com.example.springweb.dto.UserDto;
import com.example.springweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService , UserDetailsService {
    @Autowired
    private IUserReponsitory iUserReponsitory;
     @Autowired
    private ConvertDto convertDto;
    @Override
    public UserDto findUserByName(String userName) {
        return convertDto.toUserDto(iUserReponsitory.findAllByUserName(userName));
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto>userDtos = new ArrayList<>();
        List<UserEntity>us = iUserReponsitory.findAll();
        us.forEach(e->{
            userDtos.add(convertDto.toUserDto(e));
        });
        return userDtos;
    }

    @Override
    public void DeleteById(Long id) {
        iUserReponsitory.deleteById(id);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return iUserReponsitory.findAllByEmail(email);
    }

    @Override
    public UserEntity findUserByToken(String token) {
        return iUserReponsitory.findAllByToken(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEmtity =iUserReponsitory.findAllByUserName(username);
        CostumerUserDeital user= new CostumerUserDeital(userEmtity);
        if(userEmtity!=null){
            UserDetails userDetails = (UserDetails) new User(userEmtity.getUserName(), //
                    userEmtity.getPassWord(), user.getAuthorities());
            return userDetails;
        }else {
            throw new UsernameNotFoundException(username);
        }
    }

}
