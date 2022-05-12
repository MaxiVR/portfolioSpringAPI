package com.api.porfolio.security.entity;

import com.api.porfolio.model.Persona;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Usuario() {
    }

    public Usuario(@NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }
}
