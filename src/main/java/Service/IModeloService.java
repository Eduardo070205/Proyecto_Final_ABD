/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Modelo.Modelo;
import java.util.List;

public interface IModeloService {
    List<Modelo> obtenerTodos();
    
    void agregar(Modelo modelo);
    
    void eliminar(int idModelo);
    
    Modelo obtenerPorId(int idModelo);
    
}
