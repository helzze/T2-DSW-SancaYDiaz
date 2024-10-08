package com.t2.dsw.concesionaria_t2.repository;

import com.t2.dsw.concesionaria_t2.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository
        extends JpaRepository<Vehiculo, Integer> {
    // Encontrar por marca
    Optional<Vehiculo> findByMarca(String marca);

    // Encontrar por año
    Optional<Vehiculo> findByAnio(Integer anio);
    //JPQL
    //BUSCAR POR PRECIO MAYOR QUE
    @Query("SELECT v FROM Vehiculo v WHERE v.precio > :precio")
    List<Vehiculo> findVehiculosByPrecioMayorA(@Param("precio") Double precio);
    //BUSCAR POR MODELO
    @Query("SELECT v FROM Vehiculo v WHERE v.modelo = :modelo")
    List<Vehiculo> findVehiculosByModelo(@Param("modelo") String modelo);
}