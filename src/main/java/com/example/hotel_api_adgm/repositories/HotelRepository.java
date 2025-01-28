package com.example.hotel_api_adgm.repositories;

import com.example.hotel_api_adgm.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    @Query("SELECT h FROM Hotel h WHERE h.localidad = :localidad")
    List<Hotel> findByLocalidad(String localidad);
    @Query("SELECT h FROM Hotel h WHERE h.categoria = :categoria")
    List<Hotel> findByCategoria(String categoria);
}
