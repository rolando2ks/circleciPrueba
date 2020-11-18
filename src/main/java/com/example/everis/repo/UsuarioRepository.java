package com.example.everis.repo;

import com.example.everis.model.Usuario;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
    @Transactional
    void deleteByEmail(String email);
}
