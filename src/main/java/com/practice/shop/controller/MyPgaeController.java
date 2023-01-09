package com.practice.shop.controller;

import com.practice.shop.domain.AddressDto;
import com.practice.shop.domain.PaymentDto;
import com.practice.shop.domain.UserDto;
import com.practice.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mypage")
public class MyPgaeController {
    @Autowired
    AddressService addressService;
    @Autowired
    LoginService loginService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    BoardService boardService;
    @Autowired
    CartService cartService;
    @Autowired
    CommentsService commentsService;


    @GetMapping("/mypage")
    public String MyPgae(Model m, HttpSession session){
        String id = (String)session.getAttribute("id");


        try {
            UserDto userDto = loginService.userInpo(id);
            m.addAttribute("userDto", userDto);
            if(addressPoa(id)){

                AddressDto addressDto = addressService.addressSelect(id);
                m.addAttribute("addressDto",addressDto);
            }
            if(id.equals("asdf")){
                List<PaymentDto> incompleteList=paymentService.selectOrder(0);
                List<PaymentDto> completeList=paymentService.selectOrder(1);
                m.addAttribute("incompleteList",incompleteList);
                m.addAttribute("completeList",completeList);
            }else{
                List<PaymentDto> incompleteList = paymentService.selectClient(id,0);
                List<PaymentDto> completeList = paymentService.selectClient(id,1);
                m.addAttribute("incompleteList",incompleteList);
                m.addAttribute("completeList",completeList);
            }
            m.addAttribute("mode","new");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mypage";
    }

    @PostMapping("/withdrawal")
    public String withdrawal(HttpSession session){
        String id=(String)session.getAttribute("id");
        try {
            loginService.userDelete(id);
            boardService.withdrawal(id);
            addressService.addressDelete(id);
            paymentService.withdrawal(id);
            cartService.withdrawal(id);
            commentsService.withdrawal(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.invalidate();
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