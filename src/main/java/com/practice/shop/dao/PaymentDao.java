package com.practice.shop.dao;

import com.practice.shop.domain.PaymentDto;

import java.util.List;

public interface PaymentDao {
    int insert(PaymentDto paymentDto) throws Exception;

    int delete(String id, int bno) throws Exception;

    PaymentDto select(String id, int bno) throws Exception;

    List<PaymentDto> selectOrder(int delivery) throws Exception;

    List<PaymentDto> selectClient(String id, int delivery) throws Exception;

    int update(int delivery, int bno) throws Exception;
    int withdrawal(String id)throws Exception;
}
