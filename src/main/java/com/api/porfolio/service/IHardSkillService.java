package com.api.porfolio.service;

import com.api.porfolio.model.HardSkill;
import java.util.List;

public interface IHardSkillService {

    public List <HardSkill> verListaHardSkill();
    public HardSkill crearSkill(HardSkill skill);
    public void borrarSkill (Integer id);
    public HardSkill buscarSkill (Integer id);
    public HardSkill modificarSkill (HardSkill skillAux, HardSkill skillMod);
    public void setIdPerRelacion(Integer id);
}
