/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Modelo.Modelo;
import Modelo.Vehiculo;
import Repository.ModeloRepository;
import Service.IModeloService;
import Service.IVehiculoService;
import Service.ModeloService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Eduardo
 */
public class ComboBoxUtil {
    
    private ComboBoxUtil() {} 

    public static List<Integer> getAnios() {
        List<Integer> anios = new ArrayList<>();
        int anioActual = LocalDate.now().getYear();
        for (int i = anioActual; i >= 1900; i--) {
            anios.add(i);
        }
        return anios;
    }

    public static List<Integer> getCilindros() {
        return List.of(2, 3, 4, 5, 6, 8, 10, 12, 16);
    }
    
    public static List<String> getOpcionesBusquedaModelo(){
        
        return List.of("Todos", "ID", "Nombre", "Año", "Fabricante", "Cilindros", "País");
        
    }
    
    public static List<String> getMeses() {
        
        return List.of("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
        
    }
    
    public static List<Integer> getDias(){
        
        List<Integer> dias = new ArrayList<>();
        
        for(int i = 1; i <= 30; i++){
            
            dias.add(i);
            
        }
        
        return dias;
        
    }
    
    public static List<String> getTipo(){
        
        return List.of("Nuevo", "Usado");
        
    }
    
    public static List<String> getEstado(){
        
        return List.of("Disponible", "Vendido");
        
    }
    
    
    public static List<String> getModelo(IModeloService modeloService) {
        
        ArrayList<String> nombreModelo = new ArrayList<>();
    
        for(Modelo m : modeloService.obtenerTodos()){
            nombreModelo.add(m.getNombreModelo());
        }
    
        return nombreModelo;
    }
    
    public static List<String> getOpcionesBusquedaVehiculo(){
        
        return List.of("Todos", "ID", "Modelo", "Año de Fabricación", "Precio", "Tipo", "Estado");
        
    }
    
    public static List<Integer> getPrecios(){
        
        return List.of(100000, 250000, 500000, 750000, 1000000);
        
    }
    
    public static List<String> getFormaPago(){
        
        return List.of("Contado", "Credito");
        
    }
    
    public static List<String> getClientes(){
        
        return List.of("CL0001","CL0002","CL0003");
        
    }
    
    public static List<String> getEmpleados() {
        
        return List.of("EM0001","EM0002","EM0003");
        
    }
    
    public static List<String> getVehiculo(IVehiculoService vehiculoService) {
        
        ArrayList<String> idVehiculo = new ArrayList<>();
    
        for(Vehiculo v : vehiculoService.obtenerTodos()){
            idVehiculo.add(v.getIdVehiculo());
        }
    
        return idVehiculo;
    }
    
    public static List<String> getOpcionesBusquedaVentas(){
        
        return List.of("Todos","ID","Mes","Precio","Forma de Pago", "Vehiculo");
        
    }
    
    
}
