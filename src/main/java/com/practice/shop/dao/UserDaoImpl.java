package com.practice.shop.dao;


import com.practice.shop.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SqlSession session;

    private static String namespace = "com.example.shop.dao.UserInfoMapper.";
    @Override
    public int insert(UserDto dto)throws Exception{
        return session.insert(namespace+"insert",dto);
    }
    @Override
    public int delete(String id)throws Exception{
        return session.delete(namespace+"delete",id);
    }
    @Override
    public int upDate(UserDto dto)throws Exception{
        return session.update(namespace+"pswup_date",dto);
    }
    @Override
    public UserDto select(String id)throws Exception {
        return session.selectOne(namespace+"select",id);
    }

}
