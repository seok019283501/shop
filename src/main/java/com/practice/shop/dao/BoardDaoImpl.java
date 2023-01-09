package com.practice.shop.dao;

import com.practice.shop.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    SqlSession session;
    private static String namespace = "com.example.shop.dao.BoardMapper.";
    @Override
    public int insert(BoardDto boardDto)throws Exception{
        return session.insert(namespace+"insert",boardDto);
    }
    @Override
    public int delete(Integer bno, String writer)throws Exception{
        Map map = new HashMap();
        map.put("bno",bno);
        map.put("writer",writer);
        return session.delete(namespace+"delete",map);
    }
    @Override
    public List<BoardDto> selectAll() throws Exception{
        return session.selectList(namespace+"selectAll");
    }
    @Override
    public BoardDto select(Integer bno) throws Exception{
        return session.selectOne(namespace+"select",bno);
    }
    @Override
    public List<BoardDto> selectPage(int offset,int pageSize) throws Exception{
        Map map = new HashMap();
        map.put("offset",offset);
        map.put("pageSize",pageSize);
        return session.selectList(namespace+"selectPage",map);
    }
    @Override
    public int selectPageCnt()throws Exception{
        return session.selectOne(namespace+"selectPageCnt");
    }
    @Override
    public int withdrawal(String writer)throws Exception{
        return session.delete(namespace+"withdrawal",writer);
    }
}
