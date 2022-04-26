package com.api.porfolio.security.entity;

import com.api.porfolio.model.Persona;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Entity
@Getter @Setter
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String email;
    @NotNull
    private String password;
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
