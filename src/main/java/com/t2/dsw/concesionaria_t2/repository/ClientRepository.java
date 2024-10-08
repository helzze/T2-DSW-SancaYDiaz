package com.t2.dsw.concesionaria_t2.repository;

import com.t2.dsw.concesionaria_t2.dto.ClientDto;
import com.t2.dsw.concesionaria_t2.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//creando dos consultas usando JPA:
@Repository
public interface ClientRepository
        extends JpaRepository<Client, Integer> {
    //encontrar por correo, y se hizo el encontrar por id en el controller
    Optional<Client> findByCorreo(String correo);

    //JPQL
    //buscar clientes por nombre
    @Query("SELECT c FROM Client c WHERE c.nombre = :nombre")
    List<Client> findByNombre(@Param("nombre") String nombre);
    //buscar clientes por numero de telefono
    @Query("SELECT c FROM Client c WHERE c.telefono = :telefono")
    List<Client> findByTelefono(@Param("telefono") String telefono);

    //SQL NATIVO
    @Query(value = "SELECT * FROM cliente WHERE nombre LIKE %:nombre%", nativeQuery = true)
    List<Client> buscarPorNombreLike(@Param("nombre") String nombre);

    @Query(value = "SELECT COUNT(*) FROM cliente", nativeQuery = true)
    Integer countClientes();
}