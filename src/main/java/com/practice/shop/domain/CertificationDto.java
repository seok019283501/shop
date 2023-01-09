package com.practice.shop.domain;

public class CertificationDto {
    private int number;
    private String phon_num;
    public CertificationDto() {
    }
    public CertificationDto(int number,String phon_num) {
        this.number = number;
        this.phon_num=phon_num;
    }

    public String getPhon_num() {
        return phon_num;
    }

    public void setPhon_num(String phon_num) {
        this.phon_num = phon_num;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "number=" + number +
                '}';
    }
}
