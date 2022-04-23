package com.api.porfolio.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id_persona;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private String ubicacion;
    private String email;
    private String sobre_mi;
    private String url_foto;
    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<Educacion> educacion;
    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<Trabajo> trabajo;
    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<Proyecto> proyecto;
    @OneToMany
    @JoinColumn(name = "id_persona")
    private List<HardSkill> hardskill;

    public Persona() {
        
    }

    public Persona(Integer id_per, String nombre, String apellido, String fechaNac, String ubicacion, String email, String sobre_mi, String url_foto) {
        this.id_persona = id_per;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.ubicacion = ubicacion;
        this.email = email;
        this.sobre_mi = sobre_mi;
        this.url_foto = url_foto;
    }
    
}
