package com.api.porfolio.service;

import com.api.porfolio.model.Educacion;
import com.api.porfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    private EducacionRepository eduRepo;
    
    @Override
    public List <Educacion> verListaEducacion (){
        return eduRepo.findAll();
    }

    @Override
    public Educacion crearEducacion (Educacion edu){
        eduRepo.save(edu);
        return edu;
    }

    @Override
    public void borrarEducacion (Integer id){
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion (Integer id){
        return eduRepo.findById(id).orElse(null);
    }

    @Override
    public Educacion modificarEducacion (Educacion eduAux, Educacion eduMod){
       
        if(eduMod.getNombreInstitucion() != null){
            eduAux.setNombreInstitucion(eduMod.getNombreInstitucion());
        }
        if (eduMod.getFechaInicio() != null){
            eduAux.setFechaInicio(eduMod.getFechaInicio());
        }
        if (eduMod.getFechaFin() != null){
            eduAux.setFechaFin(eduMod.getFechaFin());
        }
        return eduAux;
    }
}
