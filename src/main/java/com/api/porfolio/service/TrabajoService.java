package com.api.porfolio.service;

import com.api.porfolio.model.Trabajo;
import com.api.porfolio.repository.TrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajoService implements ITrabajoService{

    @Autowired
    private TrabajoRepository trabajoRepo;
    
    /*
    public void setIdPerRelacion (Integer id){
        trabajoRepo.setIdPerRelacion(id);
    }*/

    @Override
    public List<Trabajo> verListaTrabajo(){
        return trabajoRepo.findAll();
    }

    @Override
    public Trabajo crearTrabajo (Trabajo trabajo){
       return trabajoRepo.save(trabajo);
    }

    @Override
    public void borrarTrabajo (Integer  id){
        trabajoRepo.deleteById(id);
    }
    
    @Override
    public Trabajo buscarTrabajo (Integer  id){
        return trabajoRepo.findById(id).orElse(null);
    }

    @Override
    public Trabajo modificarTrabajo (Trabajo trabajoAux, Trabajo trabajoMod){
        if(trabajoMod.getEmpresa() != null){
            trabajoAux.setEmpresa(trabajoMod.getEmpresa());
        }

        if (trabajoMod.getPuesto() != null){
            trabajoAux.setPuesto(trabajoMod.getPuesto());
        }

        if (trabajoMod.getDescripcionTrabajo() != null){
            trabajoAux.setDescripcionTrabajo(trabajoMod.getDescripcionTrabajo());
        }
        
        if (trabajoMod.getFechaInicio() != null){
            trabajoAux.setFechaInicio(trabajoMod.getFechaInicio());
        }
        if (trabajoMod.getFechaFin() != null){
            trabajoAux.setFechaFin(trabajoMod.getFechaFin());
        }
        return trabajoAux;
    }
    
}
