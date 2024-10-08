package com.t2.dsw.concesionaria_t2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idvehiculo;
    private String marca;
    private String modelo;
    private Integer anio;
    private Double precio;
}