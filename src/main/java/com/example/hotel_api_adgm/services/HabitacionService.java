package com.example.hotel_api_adgm.services;

import com.example.hotel_api_adgm.dtos.HabitacionDTO;
import com.example.hotel_api_adgm.models.Habitacion;
import com.example.hotel_api_adgm.models.Hotel;
import com.example.hotel_api_adgm.repositories.HabitacionRepository;
import com.example.hotel_api_adgm.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
    private final HabitacionRepository habitacionRepository;
    private final HotelRepository hotelRepository;

    public HabitacionService(HabitacionRepository habitacionRepository, HotelRepository hotelRepository) {
        this.habitacionRepository = habitacionRepository;
        this.hotelRepository = hotelRepository;
    }

    public void saveHabitacion(HabitacionDTO habitacionDTO,Integer id){
        Hotel hotel=hotelRepository.findById(id).get();
        Habitacion habitacion=new Habitacion();
        habitacion.setTamanio(habitacionDTO.tamanio());
        habitacion.setPrecio_noche(habitacionDTO.precio_noche());
        habitacion.setDesayuno(habitacionDTO.desayuno());
        habitacion.setOcupada(habitacionDTO.ocupada());
        habitacion.setHotel(hotel);
        habitacionRepository.save(habitacion);
    }
    public List<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }
    public void deleteHabitacionById(Integer id){
        habitacionRepository.deleteById(id);
    }
    public Optional<Habitacion> findById(Integer id) {
        return habitacionRepository.findById(id);
    }
    public void ocuparHabitacion(Integer id){
        Habitacion habitacion= habitacionRepository.findById(id).get();
        habitacion.setOcupada(true);
        habitacionRepository.save(habitacion);
    }
    public List<Habitacion> findHabitacionByTamanioAndPrecio_noche(int tamanio, double precioMin, double precioMax){
        return habitacionRepository.findHabitacionByTamanioAndPrecio_noche(tamanio,precioMin,precioMax);
    }
}
