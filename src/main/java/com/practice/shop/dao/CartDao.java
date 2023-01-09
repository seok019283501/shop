package com.practice.shop.dao;

import com.practice.shop.domain.CartDto;

import java.util.List;

public interface CartDao {
    int insert(CartDto cartDto) throws Exception;

    int delete(int cno) throws Exception;

    List<CartDto> select(String id) throws Exception;
    CartDto selectGoods(int cno)throws Exception;
    int withdrawal(String id)throws Exception;
}
