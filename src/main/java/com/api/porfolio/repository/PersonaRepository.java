package com.api.porfolio.repository;

import com.api.porfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
