package com.practice.shop.service;

import com.practice.shop.domain.CommentsDto;

import java.util.List;

public interface CommentsService {
    int insert(CommentsDto commentsDto) throws Exception;

    int delete(int cno) throws Exception;

    List<CommentsDto> select(int bno) throws Exception;

    int modify(int cno) throws Exception;
    int withdrawal(String id)throws Exception;
}
