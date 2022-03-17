package com.api.porfolio.controller;

import com.api.porfolio.model.Proyecto;
import com.api.porfolio.service.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
    
    @PostMapping ("/persona/proyecto/new")
    public Proyecto crearProyecto (@RequestBody Proyecto pro){
       return proyectoService.crearProyecto(pro);
    }

    @GetMapping ("/persona/proyecto/ver/todo")
    @ResponseBody
    public List<Proyecto> verListaProyecto(){
        return proyectoService.verListaProyecto();
    }

    @DeleteMapping ("/persona/proyecto/delete/{id}")
    public void borrarProyecto (@PathVariable Integer id){
        proyectoService.borrarProyecto(id);
    }

    
    @GetMapping ("/persona/proyecto/ver/{id}")
    @ResponseBody
    public Proyecto buscarProyecto(@PathVariable Integer id){
        return proyectoService.buscarProyecto(id);
    }    


    @PatchMapping ("persona/proyecto/modificar/{id}")
    public void modificarProyecto (@PathVariable Integer id, @RequestBody Proyecto proMod){
        Proyecto proAux = proyectoService.buscarProyecto(id);
    
        proMod = proyectoService.modificarProyecto(proAux, proMod);

        proyectoService.crearProyecto(proMod);
    }
}
