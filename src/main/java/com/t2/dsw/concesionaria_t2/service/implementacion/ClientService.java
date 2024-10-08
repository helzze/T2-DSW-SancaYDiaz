package com.t2.dsw.concesionaria_t2.service.implementacion;

import com.t2.dsw.concesionaria_t2.dto.ClientDto;
import com.t2.dsw.concesionaria_t2.model.Client;
import com.t2.dsw.concesionaria_t2.repository.ClientRepository;
import com.t2.dsw.concesionaria_t2.service.interfaz.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientDto> obtenerClientes() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> ClientDto.builder()
                        .idCliente(client.getIdcliente())
                        .nombre(client.getNombre())
                        .apellido(client.getApellido())
                        .correoElectronico(client.getCorreo())
                        .telefono(client.getTelefono())
                        .build())
                .collect(Collectors.toList());
    }
    //obtener cliente por id JPA
    @Override
    public Optional<ClientDto> obtenerCliente(Integer id) {
        return clientRepository.findById(id)
                .map(client -> ClientDto.builder()
                        .idCliente(client.getIdcliente())
                        .nombre(client.getNombre())
                        .apellido(client.getApellido())
                        .correoElectronico(client.getCorreo())
                        .telefono(client.getTelefono())
                        .build());
    }
    //obtener cliente por correo JPA
    @Override
    public Optional<ClientDto> obtenerClienteXcorreo(String correo) {
        return clientRepository.findByCorreo(correo)
                .map(client -> ClientDto.builder()
                        .idCliente(client.getIdcliente())
                        .nombre(client.getNombre())
                        .apellido(client.getApellido())
                        .correoElectronico(client.getCorreo())
                        .telefono(client.getTelefono())
                        .build());
    }
    //obtener cliente por nombre JPQL
    @Override
    public List<ClientDto> obtenerClientesPorNombre(String nombre) {
        List<Client> clients = clientRepository.findByNombre(nombre);
        return clients.stream()
                .map(client -> ClientDto.builder()
                        .idCliente(client.getIdcliente())
                        .nombre(client.getNombre())
                        .apellido(client.getApellido())
                        .correoElectronico(client.getCorreo())
                        .telefono(client.getTelefono())
                        .build())
                .collect(Collectors.toList());
    }

    //OBTENER CLIENTE POR TELEFONO jpql
    @Override
    public List<ClientDto> obtenerClientesPorTelefono(String telefono) {
        List<Client> clients = clientRepository.findByTelefono(telefono);
        return clients.stream()
                .map(client -> ClientDto.builder()
                        .idCliente(client.getIdcliente())
                        .nombre(client.getNombre())
                        .apellido(client.getApellido())
                        .correoElectronico(client.getCorreo())
                        .telefono(client.getTelefono())
                        .build())
                .collect(Collectors.toList());
    }

    //METODOS SQL NATIVO
    @Override
    public List<ClientDto> obtenerClientesPorNombreLike(String nombre) {
        List<Client> clients = clientRepository.buscarPorNombreLike(nombre);
        return clients.stream()
                .map(client -> ClientDto.builder()
                        .idCliente(client.getIdcliente())
                        .nombre(client.getNombre())
                        .apellido(client.getApellido())
                        .correoElectronico(client.getCorreo())
                        .telefono(client.getTelefono())
                        .build())
                .collect(Collectors.toList());
    }

    public Integer contarClientes() {
        return clientRepository.countClientes();
    }
}
