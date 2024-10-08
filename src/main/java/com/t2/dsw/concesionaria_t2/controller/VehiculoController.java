package com.t2.dsw.concesionaria_t2.controller;

import com.t2.dsw.concesionaria_t2.dto.VehiculoDto;
import com.t2.dsw.concesionaria_t2.exception.ResourceNotFoundException;
import com.t2.dsw.concesionaria_t2.model.Vehiculo;
import com.t2.dsw.concesionaria_t2.service.interfaz.IVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/vehiculo")
public class VehiculoController {
    private final IVehiculoService vehiculoService;


    @GetMapping("")
    public ResponseEntity<List<VehiculoDto>> listarVehiculos(){
        List<VehiculoDto> vehiculoList = vehiculoService.obtenerVehiculos();
        if (vehiculoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculoList, HttpStatus.OK);
    }

    @GetMapping("/buscarPorMarca")
    public ResponseEntity<VehiculoDto> obtenerVehiculoXmarca(
            @RequestParam String marca)
    {
        VehiculoDto vehiculoDto= vehiculoService.obtenerVehiculoXmarca(marca)
                .orElseThrow(()-> new ResourceNotFoundException("El vehiculo con marca" + marca + " no existe"));
        return new ResponseEntity<>(vehiculoDto, HttpStatus.OK);
    }

    @GetMapping("/buscarPorAnio")
    public ResponseEntity<VehiculoDto> obtenerVehiculoXanio(
            @RequestParam Integer anio)
    {
        VehiculoDto vehiculoDto = vehiculoService.obtenerVehiculoXanio(anio)
                .orElseThrow(()-> new ResourceNotFoundException("El vehiculo del año" + anio + " no existe"));
        return new ResponseEntity<>(vehiculoDto, HttpStatus.OK);
    }

    //JQPL
    @GetMapping("/buscarPorPrecioMayor")
    public ResponseEntity<List<VehiculoDto>> obtenerVehiculosPorPrecioMayor(
            @RequestParam Double precio) {
        List<VehiculoDto> vehiculos = vehiculoService.obtenerVehiculosPorPrecioMayor(precio);
        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/buscarPorModelo")
    public ResponseEntity<List<VehiculoDto>> obtenerVehiculosPorModelo(
            @RequestParam String modelo) {
        List<VehiculoDto> vehiculos = vehiculoService.obtenerVehiculosPorModelo(modelo);
        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<VehiculoDto> registrarVehiculo(@RequestBody VehiculoDto vehiculoDto) {
        VehiculoDto nuevoVehiculo = vehiculoService.registrarVehiculo(vehiculoDto);
        return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
    }
}
