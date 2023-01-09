package com.practice.shop.controller;

import com.practice.shop.domain.AddressDto;
import com.practice.shop.domain.CartDto;
import com.practice.shop.domain.GoodsDto;
import com.practice.shop.domain.PaymentDto;
import com.practice.shop.service.AddressService;
import com.practice.shop.service.CartService;
import com.practice.shop.service.GoodsService;
import com.practice.shop.service.PaymentService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    AddressService addressService;
    @Autowired
    CartService cartService;

    @GetMapping("/cart")
    public String cart(HttpSession session,Model m){
        if(!logincheck(session)){
            session.invalidate();
            return "redirect:/login/login";
        }

        String id = (String)session.getAttribute("id");

        try {

            List<CartDto> list = cartService.select(id);

            m.addAttribute("list",list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "cart";
    }

    @PostMapping("/delivery")
    public String delivery(String id,int bno, boolean btn){
        try {
            if(btn){
                paymentService.update(1,bno);
            }else{
                paymentService.delete(id,bno);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/mypage/mypage";
    }

    @PostMapping("/delete")
    public String deleteCart(int cno){

        try {
            cartService.delete(cno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/payment/cart";
    }

    @PostMapping("/cartpost")
    public String cartPost(int bno,int count,HttpSession session){
        if(!logincheck(session)){
            session.invalidate();
            return "redirect:/login/login";
        }
        try {
            GoodsDto goodsDto = goodsService.select(bno);
            String id = (String)session.getAttribute("id");
            CartDto cartDto = new CartDto(id,goodsDto.getGoodsname(),count,bno,goodsDto.getPrice());
            cartService.insert(cartDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/payment/cart";
    }

    @GetMapping("/{cno}")
    public String payment(@PathVariable int cno, Model m){
        try {
            CartDto cartDto = cartService.selectGoods(cno);
            System.out.println("cartDto.getCount() = " + cartDto.getCount());
            System.out.println("cartDto.getBno() = " + cartDto.getBno());
            GoodsDto goodsDto = goodsService.select(cartDto.getBno());
            System.out.println("goodsDto.getBno() = " + goodsDto.getBno());
            System.out.println("goodsDto.getPrice() = " + goodsDto.getPrice());
            int price = goodsDto.getPrice()*cartDto.getCount();

            m.addAttribute("goodsDto",goodsDto);
            m.addAttribute("price",price);
            m.addAttribute("count",cartDto.getCount());
            m.addAttribute("cno",cno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "payment";
    }

    @PostMapping("/pay")
    public String pay(boolean delete, int cno,int price, int bno,int count, HttpSession session){

        try {

            if(!logincheck(session)){
                session.invalidate();
                return "redirect:/login/login";
            }
            if(delete){
                cartService.delete(cno);
                return "redirect:/payment/cart";
            }
            String id = (String)session.getAttribute("id");
            AddressDto addressDto = addressService.addressSelect(id);

            GoodsDto goodsDto = goodsService.select(bno);
            PaymentDto paymentDto = new PaymentDto(id,goodsDto.getGoodsname(),price,count,0,addressDto.getPostcode(),addressDto.getRoad_address(),addressDto.getJibun_address(),addressDto.getDetail_address(),addressDto.getExtra_address());
            paymentService.insert(paymentDto);
            cartService.delete(cno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    private boolean logincheck(HttpSession session){
        return session.getAttribute("id") != null;
    }
}
