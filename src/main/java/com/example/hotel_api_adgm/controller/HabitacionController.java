package com.example.hotel_api_adgm.controller;

import com.example.hotel_api_adgm.dtos.HabitacionDTO;
import com.example.hotel_api_adgm.models.Habitacion;
import com.example.hotel_api_adgm.services.HabitacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/habitacion")
@Tag(name = "Habitación", description = "Gestion de habitaciones")
public class HabitacionController {
    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping("/")
    public List<Habitacion> getAllHabitaciones(){
        try{
            return habitacionService.findAll();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error al obtener todas las habitaciones");
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar una habitación por ID", description = "Elimina una habitación por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Habitación eliminada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Habitación no encontrada")
    })
    public void deleteHabitacion(@PathVariable @Parameter(description = "ID de la habitación a eliminar", example = "1") Integer id) {
        try {
            habitacionService.deleteHabitacionById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al eliminar la habitación por ID", e);
        }
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Editar una habitación", description = "Ocupa una habitación existente en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Habitación ocupada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "No se encontró la habitación a ocupar")
    })
    public void editHabitacion(@PathVariable @Parameter(description = "Datos de la habitación a editar") Integer id) {
        try {
            Habitacion habitacion=habitacionService.findById(id).get();
            if(!habitacion.isOcupada()){
                habitacionService.ocuparHabitacion(id);
            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La habitación ya aparece como ocupada");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al editar la habitación", e);
        }
    }
    @GetMapping("/tamañoyprecio/{tamanio}/{precioMin}/{precioMax}")
    @Operation(summary = "Obtener habitación por tamaño y precio_noche", description = "Obtiene una lista de habitaciones por tamanño y precio_noche")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Habitación encontrada con éxito"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Habitación no encontrado"),
    })

    public List<Habitacion> getByTamanioyPrecio_noche(@PathVariable int tamanio, double precioMin, double precioMax) {
        try {
            return habitacionService.findHabitacionByTamanioAndPrecio_noche(tamanio,precioMin,precioMax);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener hoteles por categoria", e);
        }
    }


    @PostMapping("/save")
    @Operation(summary = "Guardar una nueva habitación", description = "Guarda una nueva habitación en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Habitación guardada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })

    public void saveHabitacion(@RequestBody @Parameter(description = "Datos de la habitación a guardar")HabitacionDTO habitacionDTO,Integer id) {
        try {
            if(habitacionDTO.tamanio()>0 && habitacionDTO.tamanio()<=2){
                habitacionService.saveHabitacion(habitacionDTO,id);
            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El tamaño tiene que estar entre 1 y 2");
            }

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al guardar la nueva habitación", e);
        }
    }
}
