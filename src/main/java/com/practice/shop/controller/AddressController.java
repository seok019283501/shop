package com.practice.shop.controller;

import com.practice.shop.dao.AddressDao;
import com.practice.shop.domain.AddressDto;
import com.practice.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/modify")
    public String modifyview(Model m, HttpSession session){
        String id = (String)session.getAttribute("id");
        String mode = "save";
        try {
            if(addressPoa(id)){
                AddressDto addressDto = addressService.addressSelect(id);
                m.addAttribute("addressDto",addressDto);
                mode = "modify";
            }
            m.addAttribute("mode",mode);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "modifyAddress";

    }

    @PostMapping("/save")
    public String address(AddressDto addressDto, HttpSession session,String toUrl){
        String id = (String)session.getAttribute("id");
        addressDto.setId(id);
        try {
            addressService.addressInsert(addressDto);
            if(toUrl != null){
                return "redirect:"+toUrl;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/modify")
    public String modify(AddressDto addressDto,HttpSession session,String toUrl){
        try {
            String id = (String)session.getAttribute("id");
            addressDto.setId(id);
            addressService.addressUpdate(addressDto);
            if(toUrl != null){
                return "redirect:"+toUrl;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }
    private boolean addressPoa(String id){
        boolean mode=false;
        AddressDto addressDto;
        try {
            addressDto = addressService.addressSelect(id);

            if(addressDto != null){
                mode = true;
                return mode;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mode;
    }
}
