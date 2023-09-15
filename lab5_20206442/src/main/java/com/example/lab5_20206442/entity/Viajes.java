package com.example.lab5_20206442.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "viajes")
@Getter
@Setter
public class Viajes {

    @Id
    @Column(name = "idViajes")
    private Integer idViajes;

    @Column(name = "punto_recojo")
    private String punto_recojo;

    @Column(name = "cant_personas")
    private String cant_personas;

    @Column(name = "cant_perros")
    private String cant_perros;
    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona Persona_idPersona;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares")
    private Lugares Lugares_idLugares;


}
