/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Modelo.Modelo;
import Modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface IVehiculoRepository {
    
    List<Vehiculo> obtenerTodos();
    
    void agregar(Vehiculo vehiculo);
    
    void eliminar(String idVehiculo);
    
    Modelo obtenerPorId(String idVehiculo);

    void actualizar(Vehiculo vehiculo);
 
    List<Modelo> buscarPorId(String id);
    
}
