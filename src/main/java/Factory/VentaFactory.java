/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Modelo.Venta;
import java.sql.Date;

/**
 *
 * @author Eduardo
 */

//Factory Method (Venta)
public class VentaFactory {

    public static Venta actualizarVenta(
            int idVenta,
            Date fecha,
            double precio,
            String formaPago,
            String cliente,
            String empleado,
            String vehiculo
    ) {

        return new Venta(
            idVenta,
            fecha,
            precio,
            formaPago,
            cliente,
            empleado,
            vehiculo
        );
    }
    
    public static Venta crearVenta(
            Date fecha,
            double precio,
            String formaPago,
            String cliente,
            String empleado,
            String vehiculo
    ) {

        return new Venta(
                fecha,
                precio,
                formaPago,
                cliente,
                empleado,
                vehiculo
        );
    }
}
