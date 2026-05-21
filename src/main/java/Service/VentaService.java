/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Modelo.Venta;
import Repository.IVentaRepository;
import java.util.List;

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
        
        ventaRepository.agregar(venta);
        
    }

    @Override
    public void eliminar(int idVenta) {
       
        ventaRepository.eliminar(idVenta);
        
    }

    @Override
    public Venta obtenerPorId(int idVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
