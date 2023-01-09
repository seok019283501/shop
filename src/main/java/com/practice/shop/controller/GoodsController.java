package com.practice.shop.controller;

import com.practice.shop.domain.GoodsDto;
import com.practice.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @GetMapping("/read/{bno}")
    public  String read(@PathVariable int bno, Model m){
        try {
            GoodsDto goodsDto = goodsService.select(bno);
            m.addAttribute("goodsDto",goodsDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "goods";

    }

    @GetMapping("/add")
    public String add(HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        if(!managrCheck(id)){
            session.invalidate();
            return "redirect:/";
        }
        return "goodsAdd";
    }
    @PostMapping("/add")
    public String goodsadd(MultipartFile file,String goodsname,int price,String clazz){

        try {

            if(!insertCheck(file,goodsname,price)){
                System.out.println("???");
                String msg = URLEncoder.encode("모든 항목을 기입해주세요.", "utf-8");
                return "redirect:/goods/add?msg="+msg;
            }
            String goodsimg = fileImg(file);
            GoodsDto goodsDto = new GoodsDto(price,goodsname,goodsimg,clazz);
            goodsService.insert(goodsDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";

    }
    @PostMapping("/delete")
    public String delete(int bno,String goodsurl,HttpSession session){
        String id = (String)session.getAttribute("id");
        try {
            String filePath = "C:\\Users\\IdeaProjects\\shop\\src\\main\\webapp\\resources\\image";
            File file = new File(filePath+"//"+goodsurl);
            boolean result = file.delete();
            if(result){
                System.out.println("성공");
            }else{
                System.out.println("실패");
            }
            goodsService.delete(id,bno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }
    private boolean managrCheck(String id){
        boolean check = false;
        System.out.println(id);
        System.out.println(check);
        if(id==null){
            return check;
        }
        if(id.equals("asdf"))
            check = true;

        return check;
    }
    public String fileImg(MultipartFile file){
        String filename = file.getOriginalFilename();
        long size = file.getSize();
        String fileExtension = filename.substring(filename.lastIndexOf("."),filename.length());
        String uploadFolder = "C:\\Users\\IdeaProjects\\shop\\src\\main\\webapp\\resources\\image";
        UUID uuid = UUID.randomUUID();
        String[] uuids = uuid.toString().split("-");

        String uniqueName = uuids[0];
        File saveFile = new File(uploadFolder+"\\"+uniqueName+fileExtension);
        String filePath = uniqueName+fileExtension;
        try {
            file.transferTo(saveFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
    private boolean insertCheck(MultipartFile file,String goodsname,int price){
        boolean check = true;
        if(file.isEmpty() || goodsname==null || price==0){
            check=false;
        }
        return check;
    }
}
