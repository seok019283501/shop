package com.practice.shop.service;


import com.practice.shop.dao.UserDao;
import com.practice.shop.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserDao userDao;
    @Override
    public int registerSave(UserDto userDto) throws Exception{
        return userDao.insert(userDto);
    }
    public UserDto registerCheck(String id) throws Exception{
        return userDao.select(id);
    }
}
