package com.practice.shop.service;

import com.practice.shop.domain.AddressDto;

import java.util.List;

public interface AddressService {
    int addressInsert(AddressDto addressDto)throws Exception;

    int addressDelete(String id)throws Exception;

    AddressDto addressSelect(String id)throws Exception;

    int addressUpdate(AddressDto addressDto)throws Exception;

}
