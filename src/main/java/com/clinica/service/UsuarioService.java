package com.clinica.service;

import com.clinica.entity.Rol;
import com.clinica.entity.Usuario;
import com.clinica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

        Optional<Usuario> usuario = usuarioRepository.GetUserByName(nombreUsuario);

        Set<GrantedAuthority> autorizaciones = new HashSet<>();

        for (Rol rol: usuario.get().getRoles()){
            GrantedAuthority autorizacion =  new SimpleGrantedAuthority(rol.getNombre());
            autorizaciones.add(autorizacion);
        }

        org.springframework.security.core.userdetails.User userDetail =
                new org.springframework.security.core.userdetails.User(usuario.get().getNombre(),"{noop}" + usuario.get().getContrasenia(), true,true,true,true, autorizaciones);


        return userDetail;
    }
}