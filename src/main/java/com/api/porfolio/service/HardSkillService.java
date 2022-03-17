package com.api.porfolio.service;

import com.api.porfolio.model.HardSkill;
import com.api.porfolio.repository.HardSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillService implements IHardSkillService{

    @Autowired
    private HardSkillRepository hardSkillRepo;
    
    @Override
    public List <HardSkill> verListaHardSkill(){
        return hardSkillRepo.findAll();
    }
    
    @Override
    public HardSkill crearSkill(HardSkill skill){
        hardSkillRepo.save(skill);
        return skill;
    }

    @Override
    public void borrarSkill (Integer id){
        hardSkillRepo.deleteById(id);
    }

    @Override
    public HardSkill buscarSkill (Integer id){
        return hardSkillRepo.findById(id).orElse(null);
    }


    @Override
    public HardSkill modificarSkill (HardSkill skillAux, HardSkill skillMod){
        if(skillMod.getLenguaje()!= null){
            skillAux.setLenguaje(skillMod.getLenguaje());
        }
        if (skillMod.getPorcentaje()!= null){
            skillAux.setPorcentaje(skillMod.getPorcentaje());
        }
        if (skillMod.getUrlImagen()!= null){
            skillAux.setUrlImagen(skillMod.getUrlImagen());
        }
        return skillAux;
    }
}
