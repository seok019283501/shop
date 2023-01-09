package com.practice.shop.service;

import com.practice.shop.dao.AddressDao;
import com.practice.shop.domain.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressServiceimpl implements AddressService {
    @Autowired
    AddressDao addressDao;
    @Override
    public int addressInsert(AddressDto addressDto)throws Exception{
        return addressDao.insert(addressDto);
    }
    @Override
    public int addressDelete(String id)throws Exception{
        return addressDao.delete(id);
    }
    @Override
    public AddressDto addressSelect(String id)throws Exception{

        return addressDao.select(id);
    }
    @Override
    public int addressUpdate(AddressDto addressDto)throws Exception{
        return addressDao.update(addressDto);
    }

}
