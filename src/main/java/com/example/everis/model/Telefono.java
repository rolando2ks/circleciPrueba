package com.example.everis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "telefono")
public class Telefono  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long telefonoid;

    @Column(name = "number")
    private String number;

    @Column(name = "codecity")
    private String codecity;

    @Column(name = "codecountry")
    private String codecountry;

    @OneToOne(mappedBy = "telefono")
    private Usuario user;

    public Telefono() {

    }

    public Telefono(String number, String codecity, String codecountry) {
        this.number = number;
        this.codecity = codecity;
        this.codecountry = codecountry;
    }

    @JsonIgnore
    public Long getId() {
        return telefonoid;
    }

    public void setId(Long telefonoid) {
        this.telefonoid = telefonoid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCodecity() {
        return codecity;
    }

    public void setCodecity(String codecity) {
        this.codecity = codecity;
    }

    public String getCodecountry() {
        return codecountry;
    }

    public void setCodecountry(String codecountry) {
        this.codecountry = codecountry;
    }
}

