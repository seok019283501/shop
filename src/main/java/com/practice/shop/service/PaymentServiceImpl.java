package com.practice.shop.service;

import com.practice.shop.dao.PaymentDao;
import com.practice.shop.domain.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Override
    public int insert(PaymentDto paymentDto) throws Exception{
        return paymentDao.insert(paymentDto);
    }
    @Override
    public int delete(String id, int bno)throws Exception{
        return paymentDao.delete(id,bno);
    }
    @Override
    public PaymentDto select(String id, int bno)throws Exception{
        return paymentDao.select(id,bno);
    }
    @Override
    public List<PaymentDto> selectClient(String id, int delivery)throws Exception{
        System.out.println("delivery = " + delivery);
        return paymentDao.selectClient(id,delivery);
    }
    @Override
    public List<PaymentDto> selectOrder(int delivery)throws Exception{
        return paymentDao.selectOrder(delivery);
    }
    @Override
    public int update(int delrivery, int bno)throws Exception{
        return paymentDao.update(delrivery,bno);
    }
    @Override
    public int withdrawal(String id)throws Exception{
        return paymentDao.withdrawal(id);
    }
}
