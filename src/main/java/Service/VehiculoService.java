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
import util.ValidacionesUtil;

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

    @Override
    public void agregar(Vehiculo vehiculo) {
     
        if (!ValidacionesUtil.validarCamposVehiculo(vehiculo)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        vehiculoRepository.agregar(vehiculo);
        
    }

    @Override
    public void eliminar(String idVehiculo) {
        
        vehiculoRepository.eliminar(idVehiculo);
        
    }

    @Override
    public Vehiculo obtenerPorId(String idVehiculo) {
        
        return vehiculoRepository.obtenerPorId(idVehiculo);
        
    }

    @Override
    public void actualizar(Vehiculo vehiculo) {
        
        if (!ValidacionesUtil.validarCamposVehiculo(vehiculo)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        vehiculoRepository.actualizar(vehiculo);
        
    }

    @Override
    public List<Vehiculo> buscarPorId(String id) {
        
     
        return vehiculoRepository.buscarPorId(id);
    }

    @Override
    public List<Vehiculo> buscarPorModelo(String modelo) {
        
        return vehiculoRepository.buscarPorModelo(modelo);
        
    }

    @Override
    public List<Vehiculo> buscarPorAnioFab(int anio) {
        return vehiculoRepository.buscarPorAnioFab(anio);
    }

    @Override
    public List<Vehiculo> buscarPorPrecio(double precio) {
        return vehiculoRepository.buscarPorPrecio(precio);
    }

    @Override
    public List<Vehiculo> buscarPorTipo(String tipo) {
        return vehiculoRepository.buscarPorTipo(tipo);
    }

    @Override
    public List<Vehiculo> buscarPorEstado(String estado) {
        return vehiculoRepository.buscarPorEstado(estado);
    }
    

    
}
