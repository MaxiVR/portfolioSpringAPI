package com.api.porfolio.repository;

import com.api.porfolio.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer>{
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Trabajo SET id_persona = 1 WHERE id_trabajo = :id_trabajo")
    public void setIdPerRelacion (Integer id_trabajo);
}
