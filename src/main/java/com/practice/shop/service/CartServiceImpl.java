package com.practice.shop.service;

import com.practice.shop.dao.CartDao;
import com.practice.shop.domain.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Override
    public int insert(CartDto cartDto)throws Exception{
        return cartDao.insert(cartDto);
    }
    @Override
    public int delete(int cno)throws Exception{
        return cartDao.delete(cno);
    }
    @Override
    public List<CartDto> select(String id)throws Exception{
        return cartDao.select(id);
    }
    @Override
    public CartDto selectGoods(int cno)throws Exception{
        return cartDao.selectGoods(cno);
    }
    @Override
    public int withdrawal(String id)throws Exception{
        return cartDao.withdrawal(id);
    }
}
