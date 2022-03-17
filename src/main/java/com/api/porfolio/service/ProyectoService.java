package com.api.porfolio.service;

import com.api.porfolio.model.Proyecto;
import com.api.porfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepo;
    
    @Override
    public List <Proyecto> verListaProyecto (){
        return proyectoRepo.findAll();
    }

    @Override
    public Proyecto crearProyecto (Proyecto pro){
        proyectoRepo.save(pro);
        return pro;
    }


    public void borrarProyecto (Integer id){
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto (Integer id){
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public Proyecto modificarProyecto (Proyecto proAux, Proyecto proMod){
        if(proMod.getNombreProyecto() != null){
            proAux.setNombreProyecto(proMod.getNombreProyecto());
        }
        if (proMod.getDescripcionProyecto()!= null){
            proAux.setDescripcionProyecto(proMod.getDescripcionProyecto());
        }
        return proAux;
    }
}
