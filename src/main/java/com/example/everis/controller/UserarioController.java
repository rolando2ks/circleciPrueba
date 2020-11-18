package com.example.everis.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.example.everis.dto.UsuarioDataDTO;
import com.example.everis.dto.UsuarioResponseDTO;
import com.example.everis.model.Usuario;
import com.example.everis.service.UsuarioService;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
public class UserarioController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/crear")
    @ApiOperation(value = "${UserController.crear}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Error Request"), //
            @ApiResponse(code = 403, message = "Denegado"), //
            @ApiResponse(code = 200, message = "Creado"), //
            @ApiResponse(code = 422, message = "Correo existente")})
    public UsuarioResponseDTO crear(@ApiParam("Crear Usuario") @Valid @RequestBody UsuarioDataDTO user) {
        userService.crear(modelMapper.map(user, Usuario.class));
        return modelMapper.map(userService.search(user.getEmail()), UsuarioResponseDTO.class);
    }
}