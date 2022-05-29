package com.api.porfolio.service;

import com.api.porfolio.model.Educacion;
import java.util.List;


public interface IEducacionService {

    public List <Educacion> verListaEducacion ();
    public Educacion crearEducacion (Educacion edu);
    public void borrarEducacion (Integer id);
    public Educacion buscarEducacion (Integer id);
    public Educacion modificarEducacion (Educacion eduAux, Educacion eduMod);
    /*public void setIdPerRelacion(Integer id);*/
    
    
}
