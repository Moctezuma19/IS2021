package com.ejemplo.ejemplo.servicio.impl;

import com.ejemplo.ejemplo.dto.NotaDto;
import com.ejemplo.ejemplo.modelo.Nota;
import com.ejemplo.ejemplo.modelo.Usuario;
import com.ejemplo.ejemplo.repositorio.NotasRepositorio;
import com.ejemplo.ejemplo.repositorio.UsuariosRepositorio;
import com.ejemplo.ejemplo.servicio.NotasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class NotasServicioImpl implements NotasServicio {

    @Autowired
    NotasRepositorio notasRepositorio;

    @Autowired
    UsuariosRepositorio usuariosRepositorio;

    @Override
    public Nota agrega(Integer idUsuario, String texto) {

        Usuario usuario = usuariosRepositorio.findUsuarioByIdUsuario(idUsuario);
        Nota nota = new Nota();
        nota.setNota(texto);
        nota.setCreada(new Timestamp(System.currentTimeMillis()));
        nota.setIdUsuario(usuario.getIdUsuario());
        nota.setUsuario(usuario);
        return notasRepositorio.save(nota);
    }

    @Override
    public String formatoFecha(Timestamp t) {
        LocalDateTime localDateTime = t.toLocalDateTime();
        return localDateTime.getDayOfMonth() + "/" + localDateTime.getMonthValue() + "/" + localDateTime.getYear();
    }

    @Override
    public List<NotaDto> notas(Integer idUsuario) {

        List<Nota> notas = notasRepositorio.findNotasByIdUsuario(idUsuario);
        LinkedList<NotaDto> notasDto = new LinkedList<>();
        if (notas.isEmpty()) {
            return notasDto;
        }
        for (Nota n : notas) {
            NotaDto notaDto = new NotaDto();

            notaDto.setNota(n.getNota());
            notaDto.setCreada(formatoFecha(n.getCreada()));
            notasDto.add(notaDto);
        }
        return notasDto;
    }
}
