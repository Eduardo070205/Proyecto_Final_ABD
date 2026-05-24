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
    
    Vehiculo obtenerPorId(String idVehiculo);

    void actualizar(Vehiculo vehiculo);
 
    List<Vehiculo> buscarPorId(String id);
    
    List<Vehiculo> buscarPorModelo(String modelo);
    
    List<Vehiculo> buscarPorAnioFab(int anio);
    
    List<Vehiculo> buscarPorPrecio(double precio);
    
    List<Vehiculo> buscarPorTipo(String tipo);
    
    List<Vehiculo> buscarPorEstado(String estado);
    
    List<Vehiculo> obtenerVehiculosDisponibles();
    
}
