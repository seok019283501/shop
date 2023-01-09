package com.practice.shop.dao;

import com.practice.shop.domain.CommentsDto;

import java.util.List;

public interface CommentsDao {
    int insert(CommentsDto commentsDto) throws Exception;

    int delete(int cno) throws Exception;

    List<CommentsDto> select(int bno);

    int modify(int cno) throws Exception;
    int withdrawal(String id)throws Exception;
}
