package com.ejemplo.ejemplo.repository;

import com.ejemplo.ejemplo.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepositorio extends JpaRepository<Nota, Integer> {
}
