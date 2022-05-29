package com.api.porfolio.service;

import com.api.porfolio.model.SoftSkill;
import com.api.porfolio.repository.SoftSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillService implements  ISoftSkillService{
    
    @Autowired
    private SoftSkillRepository softSkillRepo;
    
    public void setIdPerRelacion (Integer id){
        softSkillRepo.setIdPerRelacion(id);
    }

    @Override
    public List <SoftSkill> verListaSoftSkill() {
        return softSkillRepo.findAll();
    }

    @Override
    public SoftSkill crearSkill(SoftSkill skill) {
        return softSkillRepo.save(skill);
    }

    @Override
    public void borrarSkill(Integer id) {
        softSkillRepo.deleteById(id);
    }

    @Override
    public SoftSkill buscarSkill(Integer id) {
        return softSkillRepo.findById(id).orElse(null);
    }

    @Override
    public SoftSkill modificarSkill(SoftSkill skillAux, SoftSkill skillMod) {
         if(skillMod.getSkill() != null){
            skillAux.setSkill(skillMod.getSkill());
        }
        if (skillMod.getUrlImagen()!= null){
            skillAux.setUrlImagen(skillMod.getUrlImagen());
        }
        return skillAux;
    }
    
}
