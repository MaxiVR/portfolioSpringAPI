package com.api.porfolio.model;

import com.api.porfolio.security.entity.Usuario;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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
