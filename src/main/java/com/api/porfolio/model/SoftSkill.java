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

@Entity
@Getter @Setter
public class SoftSkill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_softSkill;
    private String skill;
    private String urlImagen;
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "id_persona")
    private Persona persona;

    public SoftSkill() {
    }

    public SoftSkill(Integer id_softSkill, String skill, String urlImagen, Persona persona) {
        this.id_softSkill = id_softSkill;
        this.skill = skill;
        this.urlImagen = urlImagen;
        this.persona = persona;
    }
    
    
}
