package com.practice.shop.service;

import com.practice.shop.domain.CertificationDto;

public interface CertificationService {
    int insert(CertificationDto certificationDto) throws Exception;

    int delete(int number) throws Exception;

    int select(int number) throws Exception;
    int deletePhon(String phon_num)throws Exception;
}
