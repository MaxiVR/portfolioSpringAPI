package com.api.porfolio.security.entity;

import com.api.porfolio.model.Persona;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    /**@NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();**/
    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "persona", joinColumns = @JoinColumn(name = "id_persona"))
    private Persona per;

    public Usuario() {
    }

    public Usuario(@NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }
}
