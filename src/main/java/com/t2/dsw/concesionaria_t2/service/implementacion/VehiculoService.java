package com.t2.dsw.concesionaria_t2.service.implementacion;

import com.t2.dsw.concesionaria_t2.dto.VehiculoDto;
import com.t2.dsw.concesionaria_t2.model.Vehiculo;
import com.t2.dsw.concesionaria_t2.repository.VehiculoRepository;
import com.t2.dsw.concesionaria_t2.service.interfaz.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VehiculoService implements IVehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoDto> obtenerVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream()
                .map(vehiculo -> VehiculoDto.builder()
                        .idVehiculo(vehiculo.getIdvehiculo())
                        .marca(vehiculo.getMarca())
                        .modelo(vehiculo.getModelo())
                        .anio(vehiculo.getAnio())
                        .precio(vehiculo.getPrecio())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VehiculoDto> obtenerVehiculoXmarca(String marca) {
        return vehiculoRepository.findByMarca(marca)
                .map(vehiculo -> VehiculoDto.builder()
                        .idVehiculo(vehiculo.getIdvehiculo())
                        .marca(vehiculo.getMarca())
                        .modelo(vehiculo.getModelo())
                        .anio(vehiculo.getAnio())
                        .precio(vehiculo.getPrecio())
                        .build());
    }
    //obtener vehiculo por año JPA
    @Override
    public Optional<VehiculoDto> obtenerVehiculoXanio(Integer anio) {
        return vehiculoRepository.findByAnio(anio)
                .map(vehiculo -> VehiculoDto.builder()
                        .idVehiculo(vehiculo.getIdvehiculo())
                        .marca(vehiculo.getMarca())
                        .modelo(vehiculo.getModelo())
                        .anio(vehiculo.getAnio())
                        .precio(vehiculo.getPrecio())
                        .build());
    }

    @Override
    public List<VehiculoDto> obtenerVehiculosPorPrecioMayor(Double precio) {
        List<Vehiculo> vehiculos = vehiculoRepository.findVehiculosByPrecioMayorA(precio);
        return vehiculos.stream()
                .map(vehiculo -> VehiculoDto.builder()
                        .idVehiculo(vehiculo.getIdvehiculo())
                        .marca(vehiculo.getMarca())
                        .modelo(vehiculo.getModelo())
                        .anio(vehiculo.getAnio())
                        .precio(vehiculo.getPrecio())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDto> obtenerVehiculosPorModelo(String modelo) {
        List<Vehiculo> vehiculos = vehiculoRepository.findVehiculosByModelo(modelo);
        return vehiculos.stream()
                .map(vehiculo -> VehiculoDto.builder()
                        .idVehiculo(vehiculo.getIdvehiculo())
                        .marca(vehiculo.getMarca())
                        .modelo(vehiculo.getModelo())
                        .anio(vehiculo.getAnio())
                        .precio(vehiculo.getPrecio())
                        .build())
                .collect(Collectors.toList());
    }
}
