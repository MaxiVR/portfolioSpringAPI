package com.api.porfolio.model;

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
public class Trabajo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_trabajo;
    private String empresa;
    private String puesto;
    private String descripcionTrabajo;
    private String fechaInicio;
    private String fechaFin;
    @ManyToOne
    @JoinColumn (name = "id_persona")
    private Persona persona;

    public Trabajo() {
    }

    public Trabajo(Integer id_trabajo, String empresa, String puesto, String descripcionTrabajo, String fechaInicio, String fechaFin) {
        this.id_trabajo = id_trabajo;
        this.empresa = empresa;
        this.puesto = puesto;
        this.descripcionTrabajo = descripcionTrabajo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

  
    

    
}
