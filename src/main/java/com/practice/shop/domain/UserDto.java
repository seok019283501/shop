package com.practice.shop.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDto {
    private String id;
    private String psw;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String email;
    private Date reg_date;
    private int phon;

    public int getPhon() {
        return phon;
    }

    public void setPhon(int phon) {
        this.phon = phon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public UserDto(){}

    public UserDto(String id, String psw, String name, String email,int phon,Date birth) {
        this.birth=birth;
        this.id = id;
        this.psw = psw;
        this.name = name;
        this.email = email;
        this.phon=phon;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", psw='" + psw + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                '}';
    }
}
