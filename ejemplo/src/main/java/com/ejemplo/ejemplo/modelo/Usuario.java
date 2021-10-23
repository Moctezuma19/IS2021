package com.ejemplo.ejemplo.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clave")
    private String clave;

    @OneToMany(mappedBy = "usuario")
    private List<Nota> notas;
}
