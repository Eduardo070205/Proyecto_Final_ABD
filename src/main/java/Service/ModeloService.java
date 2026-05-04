/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Modelo.Modelo;
import Repository.IModeloRepository;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class ModeloService implements IModeloService {

    // DIP: depende de la interfaz, no de la implementación concreta
    private final IModeloRepository modeloRepository;

    public ModeloService(IModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @Override
    public List<Modelo> obtenerTodos() {
        return modeloRepository.obtenerTodos();
    }
    
    @Override
    public void agregar(Modelo modelo) {
        if (!validar(modelo)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        modeloRepository.agregar(modelo);
    }

    private boolean validar(Modelo modelo) {
        return modelo.getNombreModelo() != null && !modelo.getNombreModelo().isBlank()
            && modelo.getFabricante()   != null && !modelo.getFabricante().isBlank()
            && modelo.getColorBase()    != null && !modelo.getColorBase().isBlank()
            && modelo.getPaisFabricacion() != null && !modelo.getPaisFabricacion().isBlank()
            && modelo.getAnioModelo()   > 0
            && modelo.getNumeroCilindros() > 0
            && modelo.getNumeroPuertas()   > 0
            && modelo.getPesoKg()       > 0
            && modelo.getCapacidadPasajeros() > 0;
    }
    
    @Override
    public void eliminar(int idModelo) {
        modeloRepository.eliminar(idModelo);
    }

    @Override
    public Modelo obtenerPorId(int idModelo) {
        return modeloRepository.obtenerPorId(idModelo);
    }
    
    @Override
    public void actualizar(Modelo modelo) {
        if (!validar(modelo)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
        modeloRepository.actualizar(modelo);
    }
    
}