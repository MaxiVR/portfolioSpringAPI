package com.api.porfolio.controller;

import com.api.porfolio.model.SoftSkill;
import com.api.porfolio.service.ISoftSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SoftSkillController {
    
    @Autowired
    private ISoftSkillService softSkillService;

    @GetMapping("/persona/softskill/ver/todo")
    public List <SoftSkill> verListaSoftSkills (){
        return softSkillService.verListaSoftSkill();
    }
    
    @PostMapping ("/persona/softskill/new")
    public SoftSkill crearSoftSkill (@RequestBody SoftSkill skill){
        SoftSkill skillAux = softSkillService.crearSkill(skill);
        softSkillService.setIdPerRelacion(skillAux.getId_softSkill());
        return skillAux;
    }

    @DeleteMapping ("/persona/softskill/delete/{id}")
    public void borrarSoftSkill (@PathVariable Integer id){
        softSkillService.borrarSkill(id);
    }

    @GetMapping ("/persona/softskill/ver/{id}")
    @ResponseBody
    public SoftSkill buscarSoftSkill(@PathVariable Integer id){
        return softSkillService.buscarSkill(id);
    }   

    @PatchMapping ("persona/softskill/modificar/{id}")
    public void modificarSoftSkill (@PathVariable Integer id, @RequestBody SoftSkill skillMod){
        SoftSkill skillAux = softSkillService.buscarSkill(id);
    
        skillMod = softSkillService.modificarSkill(skillAux, skillMod);

        softSkillService.crearSkill(skillMod);
    }
}
