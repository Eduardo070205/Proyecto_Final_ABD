/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.Date;
import java.time.LocalDate;


/**
 *
 * @author Eduardo
 */
public class Vehiculo {
    
    private String idVehiculo;
    private String numeroSerie;
    private String nombreModelo;
    private Date fechaFabricacion;
    private double precio;
    private int kilometraje;
    private Date fechaEntrada;
    private String tipo;
    private String estado;
    
    


    public Vehiculo(String idVehiculo, String numeroSerie, String nombreModelo, Date fechaFabricacion, double precio, int kilometraje, Date fechaEntrada, String tipo, String estado) {
        this.idVehiculo = idVehiculo;
        this.numeroSerie = numeroSerie;
        this.nombreModelo = nombreModelo;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.fechaEntrada = fechaEntrada;
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    
}
