/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Eduardo
 */
public class Venta {
    
    private int idVenta;
    
    private Date fechaVenta;
    
    private String formaPago;
    
    private double precioFinal;
    
    private String idCliente;
    
    private String idEmpleado;
    
    private String nombreVehiculo;

    public Venta(int idVenta, Date fechaVenta, double precioFinal, String formaPago, String idCliente, String idEmpleado, String nombreVehiculo) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.formaPago = formaPago;
        this.precioFinal = precioFinal;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.nombreVehiculo = nombreVehiculo;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    
}
