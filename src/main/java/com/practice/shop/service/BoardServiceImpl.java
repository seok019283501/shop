package com.practice.shop.service;

import com.practice.shop.dao.BoardDao;
import com.practice.shop.domain.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;
    @Override
    public int boardsSave(BoardDto boardDto) throws Exception{
        return boardDao.insert(boardDto);
    }
    @Override
    public int boardDelete(Integer bno, String writer) throws Exception{
        return boardDao.delete(bno,writer);
    }
    @Override
    public List<BoardDto> boardSelectAll() throws Exception{
        return boardDao.selectAll();
    }
    @Override
    public BoardDto boardSelect(Integer bno) throws Exception{
        return boardDao.select(bno);
    }
    @Override
    public List<BoardDto> selectPage(int offset,int pagesize)throws Exception{
        return boardDao.selectPage(offset,pagesize);
    }
    @Override
    public int selectPageCnt()throws Exception{
        return boardDao.selectPageCnt();
    }
    @Override
    public int withdrawal(String writer)throws Exception{
        return boardDao.withdrawal(writer);
    }
}
