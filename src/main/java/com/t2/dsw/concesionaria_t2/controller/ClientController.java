package com.t2.dsw.concesionaria_t2.controller;

import com.t2.dsw.concesionaria_t2.dto.ClientDto;
import com.t2.dsw.concesionaria_t2.exception.ResourceNotFoundException;
import com.t2.dsw.concesionaria_t2.model.Client;
import com.t2.dsw.concesionaria_t2.service.interfaz.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    private final IClientService clientService;


    @GetMapping("")
    public ResponseEntity<List<ClientDto>> listarClientes(){
        List<ClientDto> clientList = clientService.obtenerClientes();
        if (clientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> obtenerClienteXid(
            @PathVariable Integer id
    ){
        ClientDto clientDto = clientService.obtenerCliente(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con el id "+id+" no existe"));
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping("/buscarPorCorreo")
    public ResponseEntity<ClientDto> obtenerClienteXcorreo(
            @RequestParam String correo)
    {
        ClientDto clientDto = clientService.obtenerClienteXcorreo(correo)
                .orElseThrow(()-> new ResourceNotFoundException("El correo" + correo + " no existe"));
        return new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<ClientDto>> obtenerClientesPorNombre(
            @RequestParam String nombre) {
        List<ClientDto> clients = clientService.obtenerClientesPorNombre(nombre);
        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/buscarPorTelefono")
    public ResponseEntity<List<ClientDto>> obtenerClientesPorTelefono(
            @RequestParam String telefono) {
        List<ClientDto> clients = clientService.obtenerClientesPorTelefono(telefono);
        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    //buscar por nombre (SQL Nativo)
    @GetMapping("/buscarPorNombreLike")
    public ResponseEntity<List<ClientDto>> obtenerClientesPorNombreLike(
            @RequestParam String nombre
    ) {
        List<ClientDto> clientes = clientService.obtenerClientesPorNombreLike(nombre);
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    //contar clientes
    @GetMapping("/contarClientes")
    public ResponseEntity<Integer> contarClientes() {
        Integer count = clientService.contarClientes();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


    @PostMapping("/registrar")
    public ResponseEntity<ClientDto> registrarCliente(@RequestBody ClientDto clientDto) {
        ClientDto nuevoCliente = clientService.registrarCliente(clientDto);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/actualizarTelefono")
    public ResponseEntity<ClientDto> actualizarTelefono(@PathVariable Integer id, @RequestParam String nuevoTelefono) {
        ClientDto clienteActualizado = clientService.actualizarTelefonoCliente(id, nuevoTelefono);
        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }

}
