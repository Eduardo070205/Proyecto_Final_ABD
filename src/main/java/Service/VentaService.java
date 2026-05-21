/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Modelo.Venta;
import Repository.IVentaRepository;
import java.util.List;
import util.ValidacionesUtil;

/**
 *
 * @author Eduardo
 */
public class VentaService implements IVentaService{
    
    private final IVentaRepository ventaRepository;
    
    public VentaService(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }
    

    @Override
    public List<Venta> obtenerTodos() {
       
        return ventaRepository.obtenerTodos();
        
    }

    @Override
    public void agregar(Venta venta) {
        
        if (!ValidacionesUtil.validarCamposVenta(venta)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        
        ventaRepository.agregar(venta);
        
    }

    @Override
    public void eliminar(int idVenta) {
       
        ventaRepository.eliminar(idVenta);
        
    }

    @Override
    public Venta obtenerPorId(int idVenta) {
        
        return ventaRepository.obtenerPorId(idVenta);
        
    }

    @Override
    public void actualizar(Venta venta) {
        
        if (!ValidacionesUtil.validarCamposVenta(venta)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        ventaRepository.actualizar(venta);
        
    }

    @Override
    public List<Venta> buscarPorId(int idVenta) {
        return ventaRepository.buscarPorId(idVenta);
    }

    @Override
    public List<Venta> buscarPorMes(String mes) {
        return ventaRepository.buscarPorMes(mes);
    }

    @Override
    public List<Venta> buscarPorPrecio(String precio) {
        return ventaRepository.buscarPorPrecio(precio);
    }

    @Override
    public List<Venta> buscarPorFormaPago(String formaPago) {
        return ventaRepository.buscarPorFormaPago(formaPago);
    }

    @Override
    public List<Venta> buscarPorVehiculo(String vehiculo) {
        return ventaRepository.buscarPorVehiculo(vehiculo);
    }
    
    
    
}
