package com.practice.shop.domain;

import org.springframework.web.multipart.MultipartFile;

public class GoodsDto {

    private String id;
    private String clazz;
    private int bno;
    private int price;
    private String goodsname;
    private String goodsimg;
    public GoodsDto(){}
    public GoodsDto(int price, String goodsname, String goodsimg,String clazz) {
        this.clazz = clazz;
        this.price = price;
        this.goodsname = goodsname;
        this.goodsimg = goodsimg;
    }

    @Override
    public String toString() {
        return "GoodsDto{" +
                "id='" + id + '\'' +
                ", bno=" + bno +
                ", price=" + price +
                ", goodsname='" + goodsname + '\'' +
                ", goodsimg='" + goodsimg + '\'' +
                '}';
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }
}
