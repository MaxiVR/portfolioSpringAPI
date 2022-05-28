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
public class HardSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_hardSkill;
    private String lenguaje;
    private Integer porcentaje;
    private String urlImagen;
    /*@JsonBackReference
    @ManyToOne
    @JoinColumn (name = "id_persona")
    private Persona persona;*/

    public HardSkill() {
    }

    public HardSkill(Integer id_hardSkill, String lenguaje, Integer porcentaje, String urlImagen) {
        this.id_hardSkill = id_hardSkill;
        this.lenguaje = lenguaje;
        this.porcentaje = porcentaje;
        this.urlImagen = urlImagen;
    }
    
    
}
