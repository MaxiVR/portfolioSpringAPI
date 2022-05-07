package com.api.porfolio.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String email;
    private int id;

    public JwtDto() {
    }

    public JwtDto(String token, String email, int id) {
        this.token = token;
        this.email = email;
        this.id = id;
    }

}
