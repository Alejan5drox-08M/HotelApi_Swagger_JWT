package com.example.hotel_api_adgm.services;


import com.example.hotel_api_adgm.dtos.HotelDTO;

import com.example.hotel_api_adgm.models.Hotel;
import com.example.hotel_api_adgm.repositories.HotelRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public void saveHotel(HotelDTO hotelDTO){
        Hotel hotel=new Hotel(hotelDTO.nombre(),hotelDTO.descripcion(),hotelDTO.categoria(),hotelDTO.piscina(),hotelDTO.localidad());
        hotelRepository.save(hotel);
    }
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
    public List<Hotel> findbyLocalidad(String localidad){
        return hotelRepository.findByLocalidad(localidad);
    }
    public List<Hotel> findbyCategoria(String categoria){
        return hotelRepository.findByCategoria(categoria);
    }
}
