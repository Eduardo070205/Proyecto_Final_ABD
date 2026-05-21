/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Modelo.Venta;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface IVentaService {
    
    List<Venta> obtenerTodos();
    
    void agregar(Venta venta);
    
    void eliminar(int idVenta);
    
    Venta obtenerPorId(int idVenta);
    
    void actualizar(Venta venta);
    
}
