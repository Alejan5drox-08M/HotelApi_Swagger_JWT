package com.example.hotel_api_adgm.controller;

import com.example.hotel_api_adgm.dtos.HotelDTO;
import com.example.hotel_api_adgm.models.Hotel;
import com.example.hotel_api_adgm.services.HotelService;
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
@RequestMapping("/api/hotel")
@Tag(name = "Hotel", description = "Gestion de hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public List<Hotel> getAllHoteles(){
        try{
            return hotelService.findAll();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error al obtener todos los hoteles");
        }
    }

    @GetMapping("/localidad/{localidad}")
    @Operation(summary = "Obtener hotel por localidad", description = "Obtiene una lista de hoteles por localidad")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Hotel encontrado con éxito"),
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
        @ApiResponse(responseCode = "404", description = "Hotel no encontrado"),
    })
    public List<Hotel> getByLocalidad(@PathVariable @Parameter(description = "Localidad del hotel", example = "Barcelona") String localidad) {
        try {
            return hotelService.findbyLocalidad(localidad);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener hoteles por localidad", e);
        }
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Obtener hotel por categoria", description = "Obtiene una lista de hoteles por categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel encontrado con éxito"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Hotel no encontrado"),
    })

    public List<Hotel> getByCategoria(@PathVariable @Parameter(description = "Categoria del hotel", example = "5 estrellas") String categoria) {
        try {
            return hotelService.findbyCategoria(categoria);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener hoteles por categoria", e);
        }
    }

    @PostMapping("/save")
    @Operation(summary = "Guardar un nuevo hotel", description = "Guarda un nuevo hotel en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hotel guardado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
    })

    public void saveHotel(@RequestBody @Parameter(description = "Datos del hotel a guardar", example = "{\"nombre\":\"Trivago\",\"descripcion\":\"Hotel mu bonico\",\"categoría\":\"1 estrella\",\"piscina\":\"true\",\"localidad\":\"Barcelona\"}") HotelDTO hotelDTO) {
        try {
            hotelService.saveHotel(hotelDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solicitud incorrecta al guardar el nuevo hotel", e);
        }
    }
}
