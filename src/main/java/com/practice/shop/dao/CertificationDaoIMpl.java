package com.practice.shop.dao;

import com.practice.shop.domain.CertificationDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationDaoIMpl implements CertificationDao {
    @Autowired
    SqlSession session;
    public static String namespace="com.example.shop.dao.CertificationMapper.";
    @Override
    public int insert(CertificationDto certificationDto)throws Exception{
        return session.insert(namespace+"insert",certificationDto);
    }
    @Override
    public int delete(int number)throws Exception{
        return session.delete(namespace+"delete",number);
    }
    @Override
    public int select(int number)throws Exception{
        return session.selectOne(namespace+"select",number);
    }
    @Override
    public int deletePhon(String phon_num)throws Exception{
        return session.delete(namespace+"deletePhon",phon_num);
    }

}
