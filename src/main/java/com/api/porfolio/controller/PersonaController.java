package com.api.porfolio.controller;

import com.api.porfolio.model.Persona;
import com.api.porfolio.service.IPersonaService;
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
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;

    @PostMapping ("/persona/new")
    public Persona crearPersona (@RequestBody Persona pers){
        return persoServ.crearPersona(pers);
    }

    @GetMapping ("/persona/ver/todo")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoServ.verPersonas();
    }

    @DeleteMapping ("/persona/delete/{id}")
    public void borrarPersona (@PathVariable Integer id){
        persoServ.borrarPersona(id);
    }

    
    @GetMapping ("/persona/ver/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Integer id){
        return persoServ.buscarPersona(id);
    }    

    @PatchMapping ("persona/modificar/{id}")
    public Persona modificarPersona (@PathVariable Integer id, @RequestBody Persona perMod){
        Persona perAux = persoServ.buscarPersona(id);
    
        perMod = persoServ.modificarPersona(perAux, perMod);

        return persoServ.crearPersona(perMod);
    }
}
