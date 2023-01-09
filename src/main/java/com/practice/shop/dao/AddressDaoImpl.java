package com.practice.shop.dao;

import com.practice.shop.domain.AddressDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AddressDaoImpl implements AddressDao {
    @Autowired
    SqlSession session;
    private String namespace="com.example.shop.dao.AddressMapper.";
    @Override
    public int insert(AddressDto addressDto)throws Exception{
        return session.insert(namespace+"insert",addressDto);
    }
    @Override
    public int delete(String id)throws Exception{
        return session.delete(namespace+"delete",id);
    }
    @Override
    public AddressDto select(String id)throws Exception{
        return session.selectOne(namespace+"select",id);
    }
    @Override
    public List<AddressDto> selectPlaceName(String id) throws Exception{
        return session.selectList(namespace+"selectPlaceName",id);
    }
    @Override
    public int update(AddressDto addressDto)throws Exception{
        return session.update(namespace+"update",addressDto);
    }

}
