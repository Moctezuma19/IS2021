package com.ejemplo.ejemplo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;

    @Column(name = "nota")
    private String nota;

    @Column(name = "creada")
    private Timestamp creada;

    @Column(name = "idUsuario", insertable = false, updatable = false)
    private Integer idUsuario;

    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

}
