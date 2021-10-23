package com.ejemplo.ejemplo.repositorio;

import com.ejemplo.ejemplo.modelo.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepositorio extends JpaRepository<Nota, Integer> {
}
