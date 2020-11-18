package com.example.everis.service;

import com.example.everis.exception.CustomException;
import com.example.everis.model.Usuario;
import com.example.everis.repo.UsuarioRepository;
import com.example.everis.security.JwtTokenProvider;
import com.example.everis.validacion.ValidacionInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UsuarioService implements ValidacionInput{

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String crear(Usuario user) {

        if(!ValidacionInput.email(user.getEmail())){
            throw new CustomException("Formato email incorrento", HttpStatus.BAD_REQUEST);
        }

        if(!ValidacionInput.password(user.getPassword())){
            throw new CustomException("Formato contraseña incorrecto", HttpStatus.BAD_REQUEST);
        }

        if (!userRepository.existsByEmail(user.getEmail())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setToken(jwtTokenProvider.createToken(user.getEmail()));
            user.setLastupdated_at(date());
            user.setTelefono(user.getTelefono());
            userRepository.save(user);
            return null;
        } else {
            throw new CustomException("El correo ya existe", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public Usuario search(String username) {
        Usuario user = userRepository.findByEmail(username);
        if (user == null) {
            throw new CustomException("Usuario no existe", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public Date date(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return  date;
    }

}
