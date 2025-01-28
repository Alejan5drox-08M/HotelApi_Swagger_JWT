package com.example.hotel_api_adgm.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
@Table(name = "Habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_habitacion;

    @Column(name = "tamanio")
    private int tamanio;

    @Column(name = "precio_noche")
    private double precio_noche;

    @Column(name = "desayuno")
    private boolean desayuno;

    @Column(name = "ocupada")
    private boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")
    @JsonBackReference
    private Hotel hotel;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, int tamanio, double precio_noche, boolean desayuno, boolean ocupada, Hotel hotel) {
        this.id_habitacion = id_habitacion;
        this.tamanio = tamanio;
        this.precio_noche = precio_noche;
        this.desayuno = desayuno;
        this.ocupada = ocupada;
        this.hotel=hotel;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id_habitacion=" + id_habitacion +
                ", tamanio=" + tamanio +
                ", precio_noche=" + precio_noche +
                ", desayuno=" + desayuno +
                ", ocupada=" + ocupada +
                ", hotel=" + hotel.getId_hotel() +
                '}';
    }
}
