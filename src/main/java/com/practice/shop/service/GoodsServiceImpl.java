package com.practice.shop.service;

import com.practice.shop.dao.GoodsDao;
import com.practice.shop.domain.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Override
    public int insert(GoodsDto goodsDto)throws Exception{
        return goodsDao.insert(goodsDto);
    }
    @Override
    public int delete(String id, int bno)throws Exception{
        return goodsDao.delete(id,bno);
    }
    @Override
    public GoodsDto select(int bno)throws Exception{
        return goodsDao.select(bno);
    }
    @Override
    public List<GoodsDto> selectAll()throws Exception{
        return goodsDao.selectAll();
    }
    @Override
    public int update(GoodsDto goodsDto)throws Exception{
        return goodsDao.update(goodsDto);
    }
    @Override
    public List<GoodsDto> selectClass(String clazz)throws Exception{
        return goodsDao.selectClass(clazz);
    }
    @Override
    public List<GoodsDto> search(String search)throws Exception{
        return goodsDao.search(search);
    }
}
