/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Modelo.Modelo;
import Modelo.Vehiculo;
import Repository.IModeloRepository;
import Repository.IVehiculoRepository;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class VehiculoService implements IVehiculoService{
    
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> obtenerTodos() {

        return vehiculoRepository.obtenerTodos();
        
    }
    

    
}
