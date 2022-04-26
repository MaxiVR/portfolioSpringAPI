package com.api.porfolio.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NuevoUsuario {
    @Email
    private String email;
    @NotBlank
    private String password;

    public NuevoUsuario() {
    }

    public NuevoUsuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    
}
