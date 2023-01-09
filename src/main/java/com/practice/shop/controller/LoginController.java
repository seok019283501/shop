package com.practice.shop.controller;

import com.practice.shop.dao.UserDao;
import com.practice.shop.domain.UserDto;
import com.practice.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @GetMapping("/login")
    public String loginfrom(){return "loginFrom";}
    @PostMapping("/login")
    public String Login( String id, String psw, HttpServletRequest request){
        if(!loginCheck(id,psw)){
            try {
                String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
                return "redirect:/login/login?msg="+msg;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        HttpSession session =request.getSession();
        session.setAttribute("id",id);
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    private boolean loginCheck(String id, String psw){
        UserDto userDto = null;
        boolean check = false;
        try {
            userDto = loginService.userLoginCheck(id);
        } catch (Exception e) {
            e.printStackTrace();
            return check;
        }

        if(userDto.getPsw().equals(psw))
            check = true;
        return check;
    }
}
