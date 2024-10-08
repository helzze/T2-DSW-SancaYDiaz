package com.t2.dsw.concesionaria_t2.service.interfaz;

import com.t2.dsw.concesionaria_t2.dto.VehiculoDto;
import com.t2.dsw.concesionaria_t2.model.Client;
import com.t2.dsw.concesionaria_t2.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface IVehiculoService {

    List<VehiculoDto> obtenerVehiculos();

    Optional<VehiculoDto> obtenerVehiculoXmarca(String marca);

    Optional<VehiculoDto> obtenerVehiculoXanio(Integer anio);

    List<VehiculoDto> obtenerVehiculosPorPrecioMayor(Double precio);

    List<VehiculoDto> obtenerVehiculosPorModelo(String modelo);

    VehiculoDto registrarVehiculo(VehiculoDto vehiculoDto);
}
