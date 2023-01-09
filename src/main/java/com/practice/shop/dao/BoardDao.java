package com.practice.shop.dao;

import com.practice.shop.domain.BoardDto;

import java.util.List;

public interface BoardDao {
    int insert(BoardDto boardDto) throws Exception;

    int delete(Integer bno, String writer) throws Exception;

    List<BoardDto> selectAll() throws Exception;

    BoardDto select(Integer bno) throws Exception;
    List<BoardDto> selectPage(int offset,int pageSize) throws Exception;
    public int selectPageCnt()throws Exception;
    int withdrawal(String writer)throws Exception;
}
