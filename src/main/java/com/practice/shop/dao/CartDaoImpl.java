package com.practice.shop.dao;

import com.practice.shop.domain.CartDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    SqlSession session;
    private static String namespace = "com.example.shop.dao.CartMapper.";
    @Override
    public int insert(CartDto cartDto)throws Exception{
        return session.insert(namespace+"insert",cartDto);
    }
    @Override
    public int delete(int cno)throws Exception{
        return session.delete(namespace+"delete",cno);
    }
    @Override
    public List<CartDto> select(String id)throws Exception{
        return session.selectList(namespace+"select",id);
    }
    @Override
    public CartDto selectGoods(int cno)throws Exception{
        return session.selectOne(namespace+"selectGoods",cno);
    }
    @Override
    public int withdrawal(String id)throws Exception{
        return session.delete(namespace+"withdrawal",id);
    }
}
