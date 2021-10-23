package com.ejemplo.ejemplo.servicio;

import com.ejemplo.ejemplo.dto.NotaDto;
import com.ejemplo.ejemplo.modelo.Nota;

import java.sql.Timestamp;
import java.util.List;

public interface NotasServicio {
    public Nota agrega(String texto);
    public String formatoFecha(Timestamp t);
    public List<NotaDto> notas();
}
