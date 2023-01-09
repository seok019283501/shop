package com.practice.shop.service;

import com.practice.shop.domain.UserDto;

public interface LoginService {
    UserDto userInpo(String id) throws Exception;

    int userDelete(String id) throws Exception;

    int userUpDate(UserDto userDto) throws Exception;
    UserDto userLoginCheck(String id) throws Exception;
}
