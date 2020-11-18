package com.example.everis.security;

import com.example.everis.model.Usuario;
import com.example.everis.repo.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Usuario user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario '" + email + "' no encontrado");
        }

        return org.springframework.security.core.userdetails.User//
                .withUsername(email)
                .password(user.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(user.isEnabled())
                .build();
    }

}
