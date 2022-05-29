package com.api.porfolio.service;

import com.api.porfolio.model.Persona;
import com.api.porfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas(){
        return persoRepo.findAll();
    }

    @Override
    public Persona crearPersona (Persona per){
        persoRepo.save(per);
        return (per);
    }

    @Override
    public void borrarPersona (Integer  id){
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona (Integer id){
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public Persona modificarPersona(Persona perAux, Persona perMod){
        
        if (perMod.getNombre() != null){
            perAux.setNombre(perMod.getNombre());
        }
        if (perMod.getApellido()!= null) {
            perAux.setApellido(perMod.getApellido());           
        }
        if (perMod.getFechaNac() != null){
            perAux.setFechaNac(perMod.getFechaNac());
        }
        if (perMod.getUbicacion() != null){
            perAux.setUbicacion(perMod.getUbicacion());
        }
        if (perMod.getEmail() != null){
            perAux.setEmail(perMod.getEmail());
        }
        if (perMod.getSobre_mi()!= null){
            perAux.setSobre_mi(perMod.getSobre_mi());
        }
        if (perMod.getUrl_foto() != null){
            perAux.setUrl_foto(perMod.getUrl_foto());
        }

        return perAux;
    }
}
