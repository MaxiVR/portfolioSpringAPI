package com.api.porfolio.controller;


import com.api.porfolio.model.Trabajo;
import com.api.porfolio.service.ITrabajoService;
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
public class TrabajoController {

    @Autowired
    private ITrabajoService trabajoService;

    @PostMapping ("/persona/trabajo/new")
    public Trabajo crearTrabajo (@RequestBody Trabajo trabajo){
       Trabajo trabajoAux = trabajoService.crearTrabajo(trabajo);
       trabajoService.setIdPerRelacion(trabajoAux.getId_trabajo());
       return  trabajoAux;
    }

    @GetMapping ("/persona/trabajo/ver/todo")
    @ResponseBody
    public List<Trabajo> verTrabajo(){
        return trabajoService.verListaTrabajo();
    }

    @DeleteMapping ("/persona/trabajo/delete/{id}")
    public void borrarTrabajo (@PathVariable Integer id){
        trabajoService.borrarTrabajo(id);
    }

    
    @GetMapping ("/persona/trabajo/ver/{id}")
    @ResponseBody
    public Trabajo buscarTrabajo(@PathVariable Integer id){
        return trabajoService.buscarTrabajo(id);
    }    


    @PatchMapping ("persona/trabajo/modificar/{id}")
    public void modificarTrabajo (@PathVariable Integer id, @RequestBody Trabajo trabajoMod){
        Trabajo trabajoAux = trabajoService.buscarTrabajo(id);
    
        trabajoMod = trabajoService.modificarTrabajo(trabajoAux, trabajoMod);

        trabajoService.crearTrabajo(trabajoMod);
    }
    
}
