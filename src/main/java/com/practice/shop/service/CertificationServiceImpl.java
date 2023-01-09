package com.practice.shop.service;

import com.practice.shop.dao.CertificationDao;
import com.practice.shop.domain.CertificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationServiceImpl implements CertificationService {
    @Autowired
    CertificationDao certificationDao;
    @Override
    public int insert(CertificationDto certificationDto)throws Exception{
        return certificationDao.insert(certificationDto);
    }
    @Override
    public int delete(int number)throws Exception{
        return certificationDao.delete(number);
    }
    @Override
    public int select(int number)throws Exception{
        return certificationDao.select(number);
    }
    @Override
    public int deletePhon(String phon_num)throws Exception{
        return certificationDao.deletePhon(phon_num);
    }
}
