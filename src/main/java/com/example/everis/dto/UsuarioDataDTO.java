package com.example.everis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;

public class UsuarioDataDTO {

    @ApiModelProperty(position = 0)
    private String name;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    private String password;

    @JsonProperty("telefono")
    private Collection<TelefonoDto> telefono;

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<TelefonoDto> getTelefono() {
        return telefono;
    }

    public void setTelefono(Collection<TelefonoDto> telefono) {
        this.telefono = telefono;
    }
}
