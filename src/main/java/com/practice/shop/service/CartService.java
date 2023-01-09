package com.practice.shop.service;

import com.practice.shop.domain.CartDto;

import java.util.List;

public interface CartService {
    int insert(CartDto cartDto) throws Exception;

    int delete(int cno) throws Exception;

    List<CartDto> select(String id) throws Exception;
    CartDto selectGoods(int cno)throws Exception;
    int withdrawal(String id)throws Exception;
}
