package com.t2.dsw.concesionaria_t2.service.interfaz;

import com.t2.dsw.concesionaria_t2.dto.ClientDto;
import com.t2.dsw.concesionaria_t2.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    List<ClientDto> obtenerClientes();

    Optional<ClientDto> obtenerCliente(Integer id);

    Optional<ClientDto> obtenerClienteXcorreo(String correo);

    List<ClientDto> obtenerClientesPorNombre(String nombre);

    List<ClientDto> obtenerClientesPorTelefono(String telefono);

    List<ClientDto> obtenerClientesPorNombreLike(String nombre);

    Integer contarClientes();

    ClientDto registrarCliente(ClientDto clientDto);

    ClientDto actualizarTelefonoCliente(Integer idCliente, String nuevoTelefono);
}
