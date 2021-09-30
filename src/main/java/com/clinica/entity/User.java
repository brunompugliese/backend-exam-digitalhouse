package com.clinica.entity;

import com.clinica.login.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;

    public User() {
    }

    public User(String nombre, String username, String email, String password, Roles roles) {
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roles.name());
        return Collections.singleton(simpleGrantedAuthority);
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
