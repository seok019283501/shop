package com.practice.shop.dao;

import com.practice.shop.domain.AddressDto;

import java.util.List;

public interface AddressDao {
    int insert(AddressDto addressDto)throws Exception;

    int delete(String id)throws Exception;

    AddressDto select(String id)throws Exception;

    int update(AddressDto addressDto)throws Exception;

    List<AddressDto> selectPlaceName(String id) throws Exception;
}
