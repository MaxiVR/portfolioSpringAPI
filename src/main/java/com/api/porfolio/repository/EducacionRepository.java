package com.api.porfolio.repository;

import com.api.porfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Educacion SET id_persona = 1 WHERE id_edu = :id_edu")
    public void setIdPerRelacion (Integer id_edu);
}
