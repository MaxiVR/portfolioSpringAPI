package com.api.porfolio.service;

import com.api.porfolio.model.Trabajo;
import java.util.List;

public interface ITrabajoService {
    
    public List<Trabajo> verListaTrabajo();
    public Trabajo crearTrabajo (Trabajo trabajo);
    public void borrarTrabajo (Integer  id);
    public Trabajo buscarTrabajo (Integer  id);
    public Trabajo modificarTrabajo (Trabajo trabajoAux, Trabajo trabajoMod);
    /*public void setIdPerRelacion(Integer id);*/
}
