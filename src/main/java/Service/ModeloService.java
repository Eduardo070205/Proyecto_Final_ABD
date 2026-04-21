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
}