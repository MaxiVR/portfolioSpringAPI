package com.api.porfolio.security.repository;

import com.api.porfolio.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional <Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    
    @Query(value = "FROM Usuario WHERE email = :email")
    public Usuario  findUsuario (String email);
    
    /*
    @Transactional
    @Modifying
    @Query(value = "UPDATE Usuario SET id_persona = 1 WHERE id = :id")
    public void setIdPerRelacion (Integer id);
    */  
}
