package com.practice.shop.domain;

public class CommentsDto {
    private int cno;
    private int bno;
    private String id;
    private String comment;

    @Override
    public String toString() {
        return "CommentsDto{" +
                "cno=" + cno +
                ", bno=" + bno +
                ", id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
    public CommentsDto(){}
    public CommentsDto(int bno, String id, String comment) {
        this.bno = bno;
        this.id = id;
        this.comment = comment;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
