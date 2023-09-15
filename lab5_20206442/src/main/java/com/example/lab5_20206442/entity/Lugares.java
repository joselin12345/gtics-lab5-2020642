package com.example.lab5_20206442.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "lugares")
public class Lugares {

    @Id
    @Column(name="idLugares")
    private Integer idLugares;

    @Column(name="nombre_lugar")
    private String nombre_lugar;

    @Column(name="descrip_lugar")
    private String descrip_lugar;

    @Column(name="fecha_lugar")
    private LocalDate fecha_lugar;



}
