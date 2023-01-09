package com.practice.shop.dao;

import com.practice.shop.domain.GoodsDto;

import java.util.List;

public interface GoodsDao {
    int insert(GoodsDto goodsDto) throws Exception;

    int delete(String id, int bno) throws Exception;

    GoodsDto select(int bno)throws Exception;

    List<GoodsDto> selectAll()throws Exception;
    int update(GoodsDto goodsDto)throws Exception;
    List<GoodsDto> selectClass(String clazz)throws Exception;
    List<GoodsDto> search(String search)throws Exception;
}
