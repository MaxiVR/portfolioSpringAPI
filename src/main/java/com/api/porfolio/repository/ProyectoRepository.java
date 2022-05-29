package com.api.porfolio.repository;

import com.api.porfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Proyecto SET id_persona = 1 WHERE id_proyecto = :id_proyecto")
    public void setIdPerRelacion (Integer id_proyecto);
    
}
