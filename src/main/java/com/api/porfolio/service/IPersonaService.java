package com.api.porfolio.service;

import com.api.porfolio.model.Persona;
import java.util.List;


public interface IPersonaService {
 
        
    public List<Persona> verPersonas();
    public void crearPersona (Persona per);
    public void borrarPersona (Integer  id);
    public Persona buscarPersona (Integer  id);
    public Persona modificarPersona (Persona perAux, Persona perMod);
    
}
