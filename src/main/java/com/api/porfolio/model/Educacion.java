package com.api.porfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_edu; 
    private String nombreInstitucion;
    private String fechaInicio;
    private String fechaFin;
    private Integer id_persona;

    public Educacion() {
    }

    public Educacion(Integer id_edu, String nombreInstitucion, String fechaInicio, String fechaFin, Integer id_persona) {
        this.id_edu = id_edu;
        this.nombreInstitucion = nombreInstitucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.id_persona = id_persona;
    }

   
    
    
}
