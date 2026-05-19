/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;


import Modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface IVehiculoService {
    
    List<Vehiculo> obtenerTodos();
    
    void agregar(Vehiculo vehiculo);
    
    void eliminar(String idVehiculo);
    
    
    
}

