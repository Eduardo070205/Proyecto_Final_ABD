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
public class VentaFactory {

    public static Venta actualizarVenta(
            int idVenta,
            String fecha,
            String precio,
            Object formaPago,
            Object cliente,
            Object empleado,
            Object vehiculo
    ) {

        return new Venta(
                idVenta,
                java.sql.Date.valueOf(fecha),
                Double.parseDouble(precio),
                formaPago.toString(),
                cliente.toString(),
                empleado.toString(),
                vehiculo.toString()
        );
    }
    
    public static Venta crearVenta(
            Date fecha,
            Object formaPago,
            String precio,
            Object cliente,
            Object empleado,
            Object vehiculo
    ) {

        return new Venta(
                fecha,
                Double.parseDouble(precio),
                formaPago.toString(),
                cliente.toString(),
                empleado.toString(),
                vehiculo.toString()
        );
    }
}
