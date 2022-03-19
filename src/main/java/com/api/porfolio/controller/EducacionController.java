package com.api.porfolio.controller;

import com.api.porfolio.model.Educacion;
import com.api.porfolio.service.IEducacionService;
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
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE})
public class EducacionController {

    @Autowired
    private IEducacionService eduService;
    
    @PostMapping ("/persona/educacion/new")
    public Educacion crearEducacion (@RequestBody Educacion edu){
        return eduService.crearEducacion(edu);
    }

    @GetMapping ("/persona/educacion/ver/todo")
    @ResponseBody
    public List<Educacion> verPersonas(){
        return eduService.verListaEducacion();
    }

    @DeleteMapping ("/persona/educacion/delete/{id}")
    public void borrarEducacion (@PathVariable Integer id){
        eduService.borrarEducacion(id);
    }

    
    @GetMapping ("/persona/educacion/ver/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Integer id){
        return eduService.buscarEducacion(id);
    }    


    @PatchMapping ("persona/educacion/modificar/{id}")
    public void modificarEducacion (@PathVariable Integer id, @RequestBody Educacion eduMod){
        Educacion eduAux = eduService.buscarEducacion(id);
    
        eduMod = eduService.modificarEducacion(eduAux, eduMod);

        eduService.crearEducacion(eduMod);
    }
}
