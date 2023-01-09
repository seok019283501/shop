package com.practice.shop.domain;
import java.util.Date;
public class BoardDto {
    private int bno;
    private String writer;
    private String title;
    private String content;
    private int viewcount;
    private int commentcount;

    private Date reg_date;

    private Date up_date;

    public BoardDto(){}
    public BoardDto(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;

    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }
}
