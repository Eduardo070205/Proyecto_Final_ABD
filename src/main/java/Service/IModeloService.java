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
    
    void actualizar(Modelo modelo);
   
    List<Modelo> buscarPorId(int id);
    
    List<Modelo> buscarPorNombre(String nombre);
    
    List<Modelo> buscarPorAnio(int anio);
    
    List<Modelo> buscarPorFabricante(String fabricante);
    
    List<Modelo> buscarPorCilindros(int cilindros);
    
    List<Modelo> buscarPorPais(String pais);
    
}
