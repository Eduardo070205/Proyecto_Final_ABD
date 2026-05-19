/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Modelo.Modelo;
import Modelo.Vehiculo;

/**
 *
 * @author Eduardo
 */
public class ValidacionesUtil {
    
    public static boolean validarCamposModelo(Modelo modelo) {
        return modelo.getNombreModelo() != null && !modelo.getNombreModelo().isBlank()
            && modelo.getFabricante()   != null && !modelo.getFabricante().isBlank()
            && modelo.getColorBase()    != null && !modelo.getColorBase().isBlank()
            && modelo.getPaisFabricacion() != null && !modelo.getPaisFabricacion().isBlank()
            && modelo.getAnioModelo()   > 0
            && modelo.getNumeroCilindros() > 0
            && modelo.getNumeroPuertas()   > 0
            && modelo.getPesoKg()       > 0
            && modelo.getCapacidadPasajeros() > 0;
    }
    
    public static boolean validarCamposVehiculo(Vehiculo vehiculo) {
    return vehiculo.getIdVehiculo() != null 
            && !vehiculo.getIdVehiculo().isBlank()

        && vehiculo.getNumeroSerie() != null 
            && !vehiculo.getNumeroSerie().isBlank()

        && vehiculo.getNombreModelo() != null 
            && !vehiculo.getNombreModelo().isBlank()

        && vehiculo.getFechaFabricacion() != null

        && vehiculo.getPrecio() > 0

        && vehiculo.getKilometraje() >= 0

        && vehiculo.getFechaEntrada() != null

        && vehiculo.getTipo() != null 
            && !vehiculo.getTipo().isBlank()

        && vehiculo.getEstado() != null 
            && !vehiculo.getEstado().isBlank();
    }
    
}
