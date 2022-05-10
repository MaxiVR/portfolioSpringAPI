package com.api.porfolio.service;

import com.api.porfolio.model.SoftSkill;
import java.util.List;


public interface ISoftSkillService {
    
    public List <SoftSkill> verListaSoftSkill();
    public SoftSkill crearSkill(SoftSkill skill);
    public void borrarSkill (Integer id);
    public SoftSkill buscarSkill (Integer id);
    public SoftSkill modificarSkill (SoftSkill skillAux, SoftSkill skillMod);
    public void setIdPerRelacion(Integer id);
}
