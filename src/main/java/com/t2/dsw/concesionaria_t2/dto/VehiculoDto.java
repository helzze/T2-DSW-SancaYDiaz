package com.t2.dsw.concesionaria_t2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VehiculoDto {
    private Integer idVehiculo;
    private String marca;
    private String modelo;
    private Integer anio;
    private Double precio;
}
