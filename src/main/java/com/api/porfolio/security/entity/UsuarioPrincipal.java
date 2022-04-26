package com.api.porfolio.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioPrincipal implements UserDetails {

    private String email;
    private String password;

    public UsuarioPrincipal( String email, String password){
        this.email = email;
        this.password = password;
    }

    public static UsuarioPrincipal build(Usuario usuario){
        return new UsuarioPrincipal( usuario.getEmail(), usuario.getPassword());
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }    
}
