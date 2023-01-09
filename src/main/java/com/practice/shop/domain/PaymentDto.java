package com.practice.shop.domain;

import java.util.Date;

public class PaymentDto {
    private String id;
    private String goodsname;
    private int price;
    private int count;
    private Date order_date;
    private int delivery;
    private int bno;
    private int postcode;
    private  String road_address;
    private  String jibun_address;
    private  String detail_address;
    private  String extra_address;
    public PaymentDto(){}
    public PaymentDto(String id, String goodsname, int price, int count, int delivery, int postcode, String road_address, String jibun_address, String detail_address, String extra_address) {
        this.id = id;
        this.goodsname = goodsname;
        this.price = price;
        this.count = count;
        this.delivery = delivery;
        this.postcode = postcode;
        this.road_address = road_address;
        this.jibun_address = jibun_address;
        this.detail_address = detail_address;
        this.extra_address = extra_address;
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id='" + id + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", delivery=" + delivery +
                ", bno=" + bno +
                ", postcode=" + postcode +
                ", road_address='" + road_address + '\'' +
                ", jibun_address='" + jibun_address + '\'' +
                ", detail_address='" + detail_address + '\'' +
                ", extra_address='" + extra_address + '\'' +
                '}';
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getRoad_address() {
        return road_address;
    }

    public void setRoad_address(String road_address) {
        this.road_address = road_address;
    }

    public String getJibun_address() {
        return jibun_address;
    }

    public void setJibun_address(String jibun_address) {
        this.jibun_address = jibun_address;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public String getExtra_address() {
        return extra_address;
    }

    public void setExtra_address(String extra_address) {
        this.extra_address = extra_address;
    }
}
