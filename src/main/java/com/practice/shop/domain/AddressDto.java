package com.practice.shop.domain;

import org.springframework.stereotype.Repository;


public class AddressDto {
    private int bno;
    private String id;
    private int postcode;
    private  String road_address;
    private  String jibun_address;
    private  String detail_address;
    private  String extra_address;


    public AddressDto(){}

    public AddressDto(int postcode, String road_address, String jibun_address, String detail_address, String extra_address) {

        this.postcode = postcode;
        this.road_address = road_address;
        this.jibun_address = jibun_address;
        this.detail_address = detail_address;
        this.extra_address = extra_address;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id='" + id + '\'' +
                ", postcode=" + postcode +
                ", road_address='" + road_address + '\'' +
                ", jibun_address='" + jibun_address + '\'' +
                ", detail_address='" + detail_address + '\'' +
                ", extra_address='" + extra_address + '\'' +
                '}';
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
