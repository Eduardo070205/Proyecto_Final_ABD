/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

/**
 *
 * @author Eduardo
 */

import Modelo.Modelo;
import Modelo.Vehiculo;
import Modelo.Venta;
import Repository.ModeloRepository;
import Repository.VehiculoRepository;
import Repository.VentaRepository;
import Factory.ModeloFactory;
import Factory.VehiculoFactory;
import Factory.VentaFactory;
import Service.IModeloService;
import Service.IVehiculoService;
import Service.IVentaService;
import Service.ModeloService;
import Service.VehiculoService;
import Service.VentaService;
import java.sql.Date;


//clase para el facade patron de diseño estructural
public class SistemaFacade {

    private final IModeloService modeloService;
    private final IVehiculoService vehiculoService;
    private final IVentaService ventaService;

    public SistemaFacade() {

        this.modeloService = new ModeloService(new ModeloRepository());

        this.vehiculoService = new VehiculoService(new VehiculoRepository());

        this.ventaService = new VentaService(new VentaRepository());
    }

    // ==================================================
    // VEHICULOS
    // ==================================================
    public void agregarVehiculo(
            String numeroVehiculo,
            String numeroSerie,
            String modelo,
            Date fechaFabricacion,
            double precio,
            int kilometraje,
            Date fechaActual,
            String tipo,
            String estado
    ) {

        Vehiculo vehiculo = VehiculoFactory.crearVehiculo(
                numeroVehiculo,
                numeroSerie,
                modelo,
                fechaFabricacion,
                precio,
                kilometraje,
                fechaActual,
                tipo,
                estado
        );

        vehiculoService.agregar(vehiculo);
    }

    // ==================================================
    // MODELOS
    // ==================================================

    public void agregarModelo(
            String nombre,
            int anio,
            String fabricante,
            int cilindros,
            int puertas,
            double peso,
            int pasajeros,
            String color,
            String pais
    ) {

        Modelo modelo = ModeloFactory.crearModelo(
                nombre,
                anio,
                fabricante,
                cilindros,
                puertas,
                peso,
                pasajeros,
                color,
                pais
        );

        modeloService.agregar(modelo);
    }

    // ==================================================
    // VENTAS
    // ==================================================

    public void agregarVenta(

            Date fecha,
            double precio,
            String formaPago,
            String cliente,
            String empleado,
            String vehiculo
    ) {

        Venta venta = VentaFactory.crearVenta(
                fecha,    
                precio,
                formaPago,
                cliente,
                empleado,
                vehiculo
        );

        ventaService.agregar(venta);
    }
}