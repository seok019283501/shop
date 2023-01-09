package com.practice.shop.service;

import com.practice.shop.dao.UserDao;
import com.practice.shop.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;
    @Override
    public UserDto userInpo(String id) throws Exception{
        return userDao.select(id);
    }
    @Override
    public int userDelete(String id) throws Exception{
        return userDao.delete(id);
    }
    @Override
    public int userUpDate(UserDto userDto) throws Exception{
        return userDao.upDate(userDto);
    }
    @Override
    public UserDto userLoginCheck(String id) throws Exception{
        return userDao.select(id);
    }
}

