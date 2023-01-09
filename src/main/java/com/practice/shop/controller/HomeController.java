package com.practice.shop.controller;


import com.practice.shop.domain.GoodsDto;
import com.practice.shop.domain.UserDto;
import com.practice.shop.service.GoodsService;
import com.practice.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    LoginService loginService;
    @Autowired
    GoodsService goodsService;
    @GetMapping("/goods/{search_in}")
    public String goods_search(@PathVariable String search_in,Model m){
        try {
            List<GoodsDto> list=goodsService.search(search_in);
            m.addAttribute("list",list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "home";
    }
    @PostMapping("/search")
    public String search(String search_in){
        System.out.println(search_in);
        return "redirect:goods/"+search_in;
    }

    @GetMapping()
    public String GoodsList(Model m){
        try {
            List<GoodsDto> list= goodsService.selectAll();
            m.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }
    @GetMapping("/{clazz}")
    public String clazz(@PathVariable String clazz, Model m){
        try {

            List<GoodsDto> list = goodsService.selectClass(clazz);

            m.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return"home";
    }

}
