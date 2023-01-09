package com.practice.shop.service;

import com.practice.shop.dao.UserDao;
import com.practice.shop.domain.UserDto;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;



public class RegisterServiceTest extends TestCase {
    @Autowired
    UserDto dto;
    @Autowired
    SqlSession session;
    @Autowired
    RegisterService registerService;
    @Autowired
    UserDao userDao;
    @Test
    public void testRegisterImpo() {
//        UserDto userDto = new UserDto("aaaa","1234","name","aaaa.aaa@.com");
//        userDao.insert(dto);
//        registerService.registerImpo(dto);
    }

    public void testModify() {
    }
}