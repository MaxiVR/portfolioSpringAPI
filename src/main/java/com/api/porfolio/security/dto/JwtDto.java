package com.api.porfolio.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String email;



    public JwtDto(String token, String email) {
        this.token = token;
        this.email = email;

    }
}
