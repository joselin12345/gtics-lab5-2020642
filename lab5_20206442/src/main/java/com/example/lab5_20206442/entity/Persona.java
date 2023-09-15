package com.example.lab5_20206442.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class Persona {

    @Id
    @Column(name="idPersona")
    private Integer idPersona;

    @Column(name="nombre")
    private String nombre;

    @Column(name="dni")
    private String dni;

    @Column(name="celular")
    private String celular;

    @Column(name="tipo_persona")
    private String tipo_persona;

}
