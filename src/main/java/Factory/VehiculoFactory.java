/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Modelo.Vehiculo;
import java.sql.Date;

/**
 *
 * @author Eduardo
 */

//Factory Method (Vehiculo)
public class VehiculoFactory {

    public static Vehiculo crearVehiculo(
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

        return new Vehiculo(
                numeroVehiculo,
                numeroSerie,
                modelo.toString(),
                fechaFabricacion,
                precio,
                kilometraje,
                fechaActual,
                tipo,
                estado
        );
    }
}