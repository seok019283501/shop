package com.practice.shop.dao;

import com.practice.shop.domain.CommentsDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsDaoImpl implements CommentsDao {
    @Autowired
    SqlSession session;
    public static String namespace="com.example.shop.dao.CommentsMapper.";

    @Override
    public int insert(CommentsDto commentsDto)throws Exception{
        return session.insert(namespace+"insert",commentsDto);
    }

    @Override
    public int delete(int cno)throws Exception{
        return session.delete(namespace+"delete",cno);
    }
    @Override
    public List<CommentsDto> select(int bno){
        return session.selectList(namespace+"select",bno);
    }
    @Override
    public int modify(int cno)throws Exception{
        return session.update(namespace+"modify",cno);
    }
    @Override
    public int withdrawal(String id)throws Exception{
        return session.delete(namespace+"withdrawal",id);
    }
}
