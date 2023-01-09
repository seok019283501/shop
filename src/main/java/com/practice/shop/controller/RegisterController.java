package com.practice.shop.controller;



import com.practice.shop.domain.UserDto;
import com.practice.shop.service.CertificationService;
import com.practice.shop.service.LoginService;
import com.practice.shop.service.RegisterService;
import org.checkerframework.checker.units.qual.A;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


@Controller
@RequestMapping("/regiser")
public class RegisterController {
    @Autowired
    CertificationService certificationService;
    @Autowired
    RegisterService registerService;
    @Autowired
    LoginService loginService;

    @GetMapping("/add")
    public String registerForm() {

        return "registerForm";
    }

    @PostMapping("/add")
    public String save(UserDto userDto,int certified){

        try {


            if(!registCheckId(userDto)){
                String msg = URLEncoder.encode("중복된 아이디입니다.", "utf-8");
                return "redirect:/register/add?msg="+msg;
            }
            int hcert = certificationService.select(certified);
            if(certified!=hcert){
                certificationService.delete(certified);
                String msg = URLEncoder.encode("다시 휴대폰 인증을 해주세요.", "utf-8");

                return "redirect:/register/add?msg="+msg;
            }

            registerService.registerSave(userDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/login/login";
    }

    private boolean registCheckId(UserDto userDto){
        UserDto userDto1;
        String id = userDto.getId();
        boolean check = true;
        try {
            userDto1 = loginService.userInpo(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(userDto1 != null){
            check = false;
        }
        return check;
    }

}
