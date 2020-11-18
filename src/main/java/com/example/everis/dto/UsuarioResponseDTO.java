package com.example.everis.dto;

import io.swagger.annotations.ApiModelProperty;

/**
id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más deseable un UUID)
created: fecha de creación del usuario
modified: fecha de la última actualización de usuario
last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación)
token: token de acceso de la API (puede ser UUID o JWT)
isactive: Indica si el usuario sigue habilitado dentro del sistema.
Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya
**/

public class UsuarioResponseDTO {

    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String name;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    private String token;
    @ApiModelProperty(position = 4)
    private String updatedAt;
    @ApiModelProperty(position = 5)
    private String lastupdated_at;
    @ApiModelProperty(position = 6)
    private String enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getLastupdated_at() {
        return lastupdated_at;
    }

    public void setLastupdated_at(String lastupdated_at) {
        this.lastupdated_at = lastupdated_at;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

}
