package com.t2.dsw.concesionaria_t2.service.implementacion;

import com.t2.dsw.concesionaria_t2.dto.ClientDto;
import com.t2.dsw.concesionaria_t2.exception.ResourceNotFoundException;
import com.t2.dsw.concesionaria_t2.model.Client;
import com.t2.dsw.concesionaria_t2.repository.ClientRepository;
import com.t2.dsw.concesionaria_t2.service.interfaz.IClientService;
import jakarta.transaction.Transactional;
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

    //Metodo transaccional registrar cliente
    @Transactional
    public ClientDto registrarCliente(ClientDto clientDto) {
        Client client = new Client();
        client.setNombre(clientDto.getNombre());
        client.setApellido(clientDto.getApellido());
        client.setCorreo(clientDto.getCorreoElectronico());
        client.setTelefono(clientDto.getTelefono());

        Client savedClient = clientRepository.save(client);
        return ClientDto.builder()
                .idCliente(savedClient.getIdcliente())
                .nombre(savedClient.getNombre())
                .apellido(savedClient.getApellido())
                .correoElectronico(savedClient.getCorreo())
                .telefono(savedClient.getTelefono())
                .build();
    }

    //Metodo transaccional actualizar telfono cliente
    @Transactional
    public ClientDto actualizarTelefonoCliente(Integer idCliente, String nuevoTelefono) {

        Client client = clientRepository.findById(idCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        client.setTelefono(nuevoTelefono);
        Client updatedClient = clientRepository.save(client);

        return ClientDto.builder()
                .idCliente(updatedClient.getIdcliente())
                .nombre(updatedClient.getNombre())
                .apellido(updatedClient.getApellido())
                .correoElectronico(updatedClient.getCorreo())
                .telefono(updatedClient.getTelefono())
                .build();
    }

}
