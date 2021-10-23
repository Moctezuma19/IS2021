package com.ejemplo.ejemplo.servicio.impl;

import com.ejemplo.ejemplo.modelo.Usuario;
import com.ejemplo.ejemplo.repositorio.UsuariosRepositorio;
import com.ejemplo.ejemplo.servicio.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServicioImpl implements UsuariosServicio {

    @Autowired
    UsuariosRepositorio usuariosRepositorio;

    @Override
    public Usuario crea(String nombre, String clave) {
        if (usuariosRepositorio.existsUsuarioByNombre(nombre)) {
            return null;
        }
        Usuario nuevo = new Usuario();
        nuevo.setNombre(nombre);
        nuevo.setClave(new BCryptPasswordEncoder().encode(clave));
        return usuariosRepositorio.saveAndFlush(nuevo);
    }
}
