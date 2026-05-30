/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Modelo.Venta;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface IVentaRepository {
    
    List<Venta> obtenerTodos();
    
    void agregar(Venta venta);
    
    void eliminar(int idVenta);
    
    Venta obtenerPorId(int idVenta);

    void actualizar(Venta venta);
    
    List<Venta> buscarPorId(int idVenta);
    
    List<Venta> buscarPorMes(String mes);
    
    List<Venta> buscarPorPrecio(String precio);
    
    List<Venta> buscarPorFormaPago(String formaPago);
    
    List<Venta> buscarPorVehiculo(String vehiculo);

    public double calcularDescuento(double precio, String formaPago);
    
    double calcularComision(double precio);

    
}
