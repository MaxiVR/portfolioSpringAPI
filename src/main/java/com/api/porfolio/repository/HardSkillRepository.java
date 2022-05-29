package com.api.porfolio.repository;

import com.api.porfolio.model.HardSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HardSkillRepository extends JpaRepository<HardSkill, Integer>{
    /*
    @Transactional
    @Modifying
    @Query(value = "UPDATE HardSkill SET id_persona = 1 WHERE id_hardSkill = :id_hardSkill")
    public void setIdPerRelacion (Integer id_hardSkill);
    */
}
