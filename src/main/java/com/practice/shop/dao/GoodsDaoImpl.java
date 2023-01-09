package com.practice.shop.dao;

import com.practice.shop.domain.BoardDto;
import com.practice.shop.domain.GoodsDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    SqlSession session;
    private static String namespace="com.example.shop.dao.GoodsMapper.";
    @Override
    public int insert(GoodsDto goodsDto)throws Exception{
        return session.insert(namespace+"insert",goodsDto);
    }
    @Override
    public int delete(String id, int bno)throws Exception{
        Map map = new HashMap();
        map.put("id",id);
        map.put("bno",bno);
        return session.delete(namespace+"delete",map);
    }
    @Override
    public GoodsDto select(int bno)throws Exception{
        return session.selectOne(namespace+"select",bno);
    }
    @Override
    public List<GoodsDto> selectAll()throws Exception{
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public int update(GoodsDto goodsDto)throws Exception{
        return session.update(namespace+"update",goodsDto);
    }
    @Override
    public List<GoodsDto> selectClass(String clazz)throws Exception{
        return session.selectList(namespace+"selectClass",clazz);
    }
    @Override
    public List<GoodsDto> search(String search)throws Exception{
        return session.selectList(namespace+"search",search);
    }
}
