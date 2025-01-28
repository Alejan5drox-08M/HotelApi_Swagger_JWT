package com.example.hotel_api_adgm.repositories;

import com.example.hotel_api_adgm.models.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion,Integer> {
    @Query("SELECT h FROM Habitacion h WHERE h.tamanio = :tamanio "+
            "AND h.precio_noche BETWEEN :precioMin AND :precioMax " +
            "AND h.ocupada = false")
    List<Habitacion> findHabitacionByTamanioAndPrecio_noche(int tamanio, double precioMin, double precioMax);
}
