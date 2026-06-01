/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Modelo.Modelo;

/**
 *
 * @author Eduardo
 */

//Factory Method pratron de diseño creacional (Modelo)
public class ModeloFactory {

    public static Modelo actualizarModelo(
            int idModelo,
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

        return new Modelo(
                idModelo,
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
    }
    
    public static Modelo crearModelo(
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

        return new Modelo(
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
    }
}
