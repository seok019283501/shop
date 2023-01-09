package com.practice.shop.service;


import com.practice.shop.domain.UserDto;

public interface RegisterService {
    int registerSave(UserDto userDto) throws Exception;
    UserDto registerCheck(String id) throws Exception;

}
