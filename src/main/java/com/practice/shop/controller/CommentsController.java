package com.practice.shop.controller;

import com.practice.shop.domain.CommentsDto;
import com.practice.shop.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
public class CommentsController {
    @Autowired
    CommentsService commentsService;
    @PostMapping("/comment")
    public CommentsDto comment(@RequestBody CommentsDto commentsDto, HttpSession session){
        System.out.println(commentsDto.getComment());
        String id = (String)session.getAttribute("id");
        commentsDto.setId(id);
        System.out.println("commentsDto.getId() = " + commentsDto.getId());
        try {
            commentsService.insert(commentsDto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return commentsDto;
    }
}
