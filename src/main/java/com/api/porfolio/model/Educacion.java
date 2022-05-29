package com.api.porfolio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    /*@JsonBackReference*/
    @ManyToOne
    @JoinColumn (name = "id_persona")
    private Persona persona;

    public Educacion() {
    }
    

    public Educacion(Integer id_edu, String nombreInstitucion, String fechaInicio, String fechaFin) {
        this.id_edu = id_edu;
        this.nombreInstitucion = nombreInstitucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    

    
}
