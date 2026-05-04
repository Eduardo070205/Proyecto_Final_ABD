/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Modelo.Modelo;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public interface IModeloRepository {
    
    List<Modelo> obtenerTodos();
    
    void agregar(Modelo modelo);
    
    void eliminar(int idModelo);
    
    Modelo obtenerPorId(int idModelo);

    void actualizar(Modelo modelo);
    
}
