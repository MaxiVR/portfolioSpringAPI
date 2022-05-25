package com.api.porfolio.controller;

import com.api.porfolio.model.HardSkill;
import com.api.porfolio.service.IHardSkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HardSkillController {

    @Autowired
    private IHardSkillService hardSkillService;

    @GetMapping("/persona/hardskill/ver/todo")
    public List <HardSkill> verListaSkills (){
        return hardSkillService.verListaHardSkill();
    }
    
    @PostMapping ("/persona/hardskill/new")
    public HardSkill crearSkill (@RequestBody HardSkill skill){
        HardSkill skillAux = hardSkillService.crearSkill(skill);
        hardSkillService.setIdPerRelacion(skillAux.getId_hardSkill());
        return skillAux;
    }

    @DeleteMapping ("/persona/hardskill/delete/{id}")
    public void borrarSkill (@PathVariable Integer id){
        hardSkillService.borrarSkill(id);
    }

    @GetMapping ("/persona/hardskill/ver/{id}")
    @ResponseBody
    public HardSkill buscarSkill(@PathVariable Integer id){
        return hardSkillService.buscarSkill(id);
    }   

    @PatchMapping ("persona/hardskill/modificar/{id}")
    public void modificarSkill (@PathVariable Integer id, @RequestBody HardSkill skillMod){
        HardSkill skillAux = hardSkillService.buscarSkill(id);
    
        skillMod = hardSkillService.modificarSkill(skillAux, skillMod);

        hardSkillService.crearSkill(skillMod);
    }
}
