package com.example.everis.dto;

import io.swagger.annotations.ApiModelProperty;

public class TelefonoDto {

    @ApiModelProperty(position = 0)
    private String number;
    @ApiModelProperty(position = 1)
    private String codecity;
    @ApiModelProperty(position = 2)
    private String codecountry;

    public String getNumber() {
        return number;
    }
    public String getCitycode() {
        return codecity;
    }
    public String getContrycode() { return codecountry; }
}
