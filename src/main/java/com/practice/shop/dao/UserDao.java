package com.practice.shop.dao;


import com.practice.shop.domain.UserDto;

public interface UserDao {
    int insert(UserDto dto) throws Exception;

    int delete(String id) throws Exception;

    int upDate(UserDto dto) throws Exception;
    UserDto select(String id) throws Exception;
}
