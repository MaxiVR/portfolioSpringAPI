package com.api.porfolio.repository;


import com.api.porfolio.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SoftSkillRepository extends JpaRepository<SoftSkill, Integer>{
    /*
    @Transactional
    @Modifying
    @Query(value = "UPDATE SoftSkill SET id_persona = 1 WHERE id_softSkill = :id_softSkill")
    public void setIdPerRelacion (Integer id_softSkill);
    */
}
