package com.ejemplo.ejemplo.repositorio;

import com.ejemplo.ejemplo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuario, Integer> {

    Usuario findUsuarioByNombre(String nombre);

    Usuario findUsuarioByIdUsuario(Integer idUsuario);

    Boolean existsUsuarioByNombre(String nombre);

}
