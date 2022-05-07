package com.api.porfolio.security.repository;

import com.api.porfolio.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional <Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    
    @Query(value = "FROM Usuario WHERE email = :email")
    public Usuario  findUsuario (String email);
    
}
