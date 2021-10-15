package com.ejemplo.ejemplo.servicio.impl;

import com.ejemplo.ejemplo.model.Nota;
import com.ejemplo.ejemplo.repository.NotasRepositorio;
import com.ejemplo.ejemplo.servicio.NotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotasServicioImpl implements NotasServicio {

    @Autowired
    NotasRepositorio notasRepositorio;

    @Override
    public void agrega(String texto) {
        Nota nota = new Nota();
        nota.setNota(texto);
        System.out.println(nota);
        notasRepositorio.save(nota);
    }
}
