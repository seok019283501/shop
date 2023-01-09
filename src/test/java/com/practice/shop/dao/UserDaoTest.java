package com.practice.shop.dao;

import com.practice.shop.domain.UserDto;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends TestCase {
    @Autowired
    UserDao userDao;
    public void testInsert()throws Exception {

        UserDto userDto = userDao.select("asdf");
        System.out.println("userDto.getId() = " + userDto.getId());

    }

    public void testDelete() {
    }

    public void testPswUpDate() {
    }
}