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
public class Proyecto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_proyecto;
    private String nombreProyecto;
    private String descripcionProyecto;
    @ManyToOne
    @JoinColumn (name = "id_persona")
    private Persona persona;

    public Proyecto() {
    }

    public Proyecto(Integer id_proyecto, String nombreProyecto, String descripcionProyecto, Integer id_persona) {
        this.id_proyecto = id_proyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }
   
}
