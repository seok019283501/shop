package com.practice.shop.dao;


import com.practice.shop.domain.PaymentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PaymentDaoImpl implements PaymentDao {
    @Autowired
    SqlSession session;
    private String namespace = "com.example.shop.dao.PaymentMapper.";
    @Override
    public int insert(PaymentDto paymentDto)throws Exception{
        return session.insert(namespace+"insert",paymentDto);
    }
    @Override
    public int delete(String id, int bno)throws Exception{
        Map map = new HashMap();
        map.put("id",id);
        map.put("bno",bno);
        return session.delete(namespace+"delete",map);
    }
    @Override
    public PaymentDto select(String id, int bno)throws Exception{
        Map map = new HashMap();
        map.put("id",id);
        map.put("bno",bno);
        return session.selectOne(namespace+"select",map);
    }
    @Override
    public List<PaymentDto> selectOrder(int delivery)throws Exception{
        return session.selectList(namespace+"selectOrder",delivery);
    }
    @Override
    public List<PaymentDto> selectClient(String id, int delivery) throws Exception{
        Map map = new HashMap();
        map.put("id",id);
        map.put("delivery",delivery);
        System.out.println("map.get(\"delivery\") = " + map.get("delivery"));
        return session.selectList(namespace+"selectClient",map);
    }
    @Override
    public int update(int delivery, int bno)throws Exception{
        Map map = new HashMap();
        map.put("delivery",delivery);
        map.put("bno",bno);
        return session.update(namespace+"deliveryUpdate",map);
    }
    @Override
    public int withdrawal(String id)throws Exception{
        return session.delete(namespace+"withdrawal",id);
    }

}
