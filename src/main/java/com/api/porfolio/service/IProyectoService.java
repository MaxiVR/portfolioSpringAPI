package com.api.porfolio.service;

import com.api.porfolio.model.Proyecto;
import java.util.List;


public interface IProyectoService {

    public List <Proyecto> verListaProyecto ();
    public Proyecto crearProyecto (Proyecto pro);
    public void borrarProyecto (Integer id);
    public Proyecto buscarProyecto (Integer id);
    public Proyecto modificarProyecto (Proyecto proAux, Proyecto proMod);
    
}
