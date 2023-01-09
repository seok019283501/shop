package com.practice.shop.controller;


import com.practice.shop.domain.BoardDto;
import com.practice.shop.domain.CommentsDto;
import com.practice.shop.service.BoardService;
import com.practice.shop.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    CommentsService commentsService;

    @GetMapping("/read/{n}/{offset}/{bno}")
    public String read(@PathVariable int n,@PathVariable int offset,@PathVariable Integer bno,Model m){
        String mode="read";
        try {
            BoardDto boardDto = boardService.boardSelect(bno);
            List<CommentsDto> list=commentsService.select(bno);
            m.addAttribute("boardDto",boardDto);
            m.addAttribute("list",list);
            m.addAttribute("n",n);
            m.addAttribute("offset",offset);
            m.addAttribute("mode",mode);
        } catch (Exception e) {
            e.printStackTrace();
        }



        return "board";
    }

    @GetMapping("/board/{n}/{offset}")
    public String board(@PathVariable int n,@PathVariable int offset, HttpSession session,Model m){
        if(!(logincheck(session))){
            session.invalidate();
            return "redirect:/login/login";
        }
        m.addAttribute("n",n);
        m.addAttribute("offset",offset);
        return "board";
    }



    @PostMapping("/board")
    public String boardsave(int n ,int offset,BoardDto boardDto, HttpSession session, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("id");
        boardDto.setWriter(writer);
        try {
            int rowCnt = boardService.boardsSave(boardDto);
            if(rowCnt !=1)
                throw new Exception("Write failed");
            rattr.addFlashAttribute("msg","WRT_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","WRT_OK");
            return "redirect:/board/board";
        }
        return "redirect:/board/list/"+n+"/"+offset;


    }
    @GetMapping("/list/{n}/{offset}")
    public String boardList(@PathVariable int n,@PathVariable int offset, HttpSession session, Model m){
        int now = n;
        System.out.println("offset = " + offset);
        if(!(logincheck(session))){
            session.invalidate();
            return "redirect:/login/login";
        }

        try {
            int count = boardService.selectPageCnt();
            if(count%10==0){
                count= count/10-1;
            }
            else {
                count/=10;
            }
            int front = n/10*10;
            int end = front+9;
            List<BoardDto> list=boardService.selectPage(offset-1,10);
            m.addAttribute("now",now);
            m.addAttribute("count",count);
            m.addAttribute("front",front);
            m.addAttribute("end",end);
            m.addAttribute("list",list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "boardList";
    }

    private boolean logincheck(HttpSession session){
        return session.getAttribute("id") != null;
    }
}
