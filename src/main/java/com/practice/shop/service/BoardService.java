package com.practice.shop.service;

import com.practice.shop.domain.BoardDto;

import java.util.List;

public interface BoardService {
    int boardsSave(BoardDto boardDto) throws Exception;

    int boardDelete(Integer bno, String writer) throws Exception;

    List<BoardDto> boardSelectAll() throws Exception;

    BoardDto boardSelect(Integer bno) throws Exception;
    List<BoardDto> selectPage(int offset,int pagesize)throws Exception;
    int selectPageCnt()throws Exception;
    int withdrawal(String writer)throws Exception;
}
