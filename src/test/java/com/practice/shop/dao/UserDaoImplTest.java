package com.practice.shop.dao;

import com.practice.shop.domain.UserDto;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest extends TestCase {
    @Autowired
    private UserDao userDao;
    @Test
    public void testInsert() {
//        UserDto userDto = new UserDto("aaaa","1234","name","aaaa@aaa.com");
//        assertTrue(userDao.insert(userDto)==1);
    }

    public void testDelete() {
    }

    public void testPswUpDate() {
    }
}