package com.practice.shop.domain;

public class CartDto {
    private String id;
    private String goodsname;
    private int count;
    private int bno;
    private int cno;
    private int price;
    @Override
    public String toString() {
        return "CartDto{" +
                "id='" + id + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", count=" + count +
                ", bno=" + bno +
                ", cno=" + cno +
                '}';
    }
    public CartDto(){}
    public CartDto(String id, String goodsname, int count, int bno,int price) {
        this.price = price;
        this.id = id;
        this.goodsname = goodsname;
        this.count = count;
        this.bno = bno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }
}
