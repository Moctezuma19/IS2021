package com.ejemplo.ejemplo.servicio.impl;

import com.ejemplo.ejemplo.modelo.Usuario;
import com.ejemplo.ejemplo.repositorio.UsuariosRepositorio;
import com.ejemplo.ejemplo.servicio.DetalleUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DetalleUsuarioServicioImpl implements DetalleUsuarioServicio, UserDetailsService {

    @Autowired
    UsuariosRepositorio usuariosRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuarioActivo = usuariosRepositorio.findUsuarioByNombre(nombre);
        UserDetails userDetails;
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioActivo.getNombre());
        userDetails = (UserDetails) new User(usuarioActivo.getNombre(), usuarioActivo.getClave(), Arrays.asList(grantedAuthority));
        return userDetails;
    }

}
