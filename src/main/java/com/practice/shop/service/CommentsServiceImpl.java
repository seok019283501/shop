package com.practice.shop.service;

import com.practice.shop.dao.CommentsDao;
import com.practice.shop.domain.CommentsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentsDao commentsDao;
    @Override
    public int insert(CommentsDto commentsDto)throws Exception{
        return commentsDao.insert(commentsDto);
    }
    @Override
    public int delete(int cno)throws Exception{
        return commentsDao.delete(cno);
    }
    @Override
    public List<CommentsDto> select(int bno)throws Exception{
        return commentsDao.select(bno);
    }
    @Override
    public int modify(int cno)throws Exception{
        return commentsDao.modify(cno);
    }
    @Override
    public int withdrawal(String id)throws Exception{
        return commentsDao.withdrawal(id);
    }
}
