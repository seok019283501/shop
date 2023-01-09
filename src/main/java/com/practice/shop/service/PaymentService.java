package com.practice.shop.service;

import com.practice.shop.dao.PaymentDao;
import com.practice.shop.domain.PaymentDto;

import java.util.List;

public interface PaymentService {
    int insert(PaymentDto paymentDto) throws Exception;

    int delete(String id, int bno) throws Exception;

    PaymentDto select(String id, int bno) throws Exception;

    List<PaymentDto> selectClient(String id, int delivery) throws Exception;

    List<PaymentDto> selectOrder(int delivery) throws Exception;

    int update(int delrivery, int bno) throws Exception;
    int withdrawal(String id)throws Exception;
}
