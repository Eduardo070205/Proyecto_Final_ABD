/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Modelo.Modelo;
import Modelo.Vehiculo;
import Modelo.Venta;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author Eduardo
 */
public class ValidacionesUtil {
    
    static boolean puntoDecimal = false;
    
    static boolean agregar = false;
    
    public static boolean validarCamposModelo(Modelo modelo) {
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
    
    public static boolean validarCamposVehiculo(Vehiculo vehiculo) {
    return vehiculo.getIdVehiculo() != null 
            && !vehiculo.getIdVehiculo().isBlank()

        && vehiculo.getNumeroSerie() != null 
            && !vehiculo.getNumeroSerie().isBlank()

        && vehiculo.getNombreModelo() != null 
            && !vehiculo.getNombreModelo().isBlank()

        && vehiculo.getFechaFabricacion() != null

        && vehiculo.getPrecio() > 0

        && vehiculo.getKilometraje() >= 0

        && vehiculo.getFechaEntrada() != null

        && vehiculo.getTipo() != null 
            && !vehiculo.getTipo().isBlank()

        && vehiculo.getEstado() != null 
            && !vehiculo.getEstado().isBlank();
    }
    
    public static boolean validarCamposVenta(Venta venta) {

        return venta.getFechaVenta() != null

            && venta.getFormaPago() != null
            && !venta.getFormaPago().isBlank()

            && venta.getPrecioFinal() > 0

            && venta.getIdCliente() != null
            && !venta.getIdCliente().isBlank()

            && venta.getIdEmpleado() != null
            && !venta.getIdEmpleado().isBlank()

            && venta.getNombreVehiculo() != null
            && !venta.getNombreVehiculo().isBlank();
    }
    

    
    public static void validarNumeros(JTextField caja, JInternalFrame internal, char accion){
        
        String ultimoElemento;
        
        String cadena = caja.getText();
        byte contPuntos = 0;
        
        if(accion == 'U' && caja.getText().contains(".")){
            puntoDecimal = true;
        }
        
      
        int numeroCaracteres = (caja.getText().length());
 
        
        if(numeroCaracteres == 0){
            
            ultimoElemento = null;
            
        }else{
       
            ultimoElemento = String.valueOf(caja.getText().charAt(numeroCaracteres-1));
            
        }
        
        for(int i = 0; i < cadena.length(); i++){
            
            if(cadena.charAt(i) == 46){
                
                contPuntos++;
                
            }
            
        }
        
        if(contPuntos == 0){
            
            puntoDecimal = false;
            
        }
        
        
        
        if(ultimoElemento != null){
            
            if((ultimoElemento.codePointAt(0) >= 48 && ultimoElemento.codePointAt(0) <= 57) || (ultimoElemento.charAt(0) == 46 && puntoDecimal == false)){        
            
                if(ultimoElemento.charAt(0) == 46){

                    puntoDecimal = true;

                }
            
            }else{

                JOptionPane.showMessageDialog(internal, "Solo puedes ingresar numéros");

                caja.setText(cadena.substring(0, cadena.length()-1));

            }
            
        }
            
    }
    
    public static void validarLetrasNumeros(JTextField caja, JInternalFrame internal){
        
        String ultimoElemento;
        
        String cadena = caja.getText();
        
        int numeroCaracteres = (caja.getText().length());
 
        
        if(numeroCaracteres == 0){
            
            ultimoElemento = null;
            
        }else{
       
            ultimoElemento = String.valueOf(caja.getText().toUpperCase().charAt(numeroCaracteres-1));
            
        }
        
        
        
        if(ultimoElemento != null){
            
            if((ultimoElemento.codePointAt(0) >= 48 && ultimoElemento.codePointAt(0) <= 57) || (ultimoElemento.codePointAt(0) >= 65 && ultimoElemento.codePointAt(0) <= 90)){        
            
                // Son números y letras
            
            }else{

                JOptionPane.showMessageDialog(internal, "Solo puedes ingresar letras y números");

                caja.setText(cadena.substring(0, cadena.length()-1));

            }
            
        }
        
    }
    
    public static void validarLetras(JTextField caja, JInternalFrame internal){
        
        
        String ultimoElemento;
        
        String cadena = caja.getText();
        
        int numeroCaracteres = (caja.getText().length());
 
        
        if(numeroCaracteres == 0){
            
            ultimoElemento = null;
            
        }else{
       
            ultimoElemento = String.valueOf(caja.getText().toUpperCase().charAt(numeroCaracteres-1));
            
        }
        
        
        
        if(ultimoElemento != null){
            
            if((ultimoElemento.codePointAt(0) >= 65 && ultimoElemento.codePointAt(0) <= 90)){        
            
                // Son letras
            
            }else{

                JOptionPane.showMessageDialog(internal, "Solo puedes ingresar letras");

                caja.setText(cadena.substring(0, cadena.length()-1));

            }
            
        }
        
    }
    
    public static String validarFecha(JComboBox comboAnio, JComboBox comboMes, JComboBox comboDia, JInternalFrame internal){
        
        agregar = true;
        
        LocalDate hoy = LocalDate.now();
        
        int diaHoy = hoy.getDayOfMonth();
        
        int mesHoy =  hoy.getMonthValue();
        
        int anioHoy = hoy.getYear();
        
        String anio = comboAnio.getSelectedItem().toString();
        
        
        String mes, dia;
        
        if(String.valueOf(comboMes.getSelectedIndex()+1).length() == 1){
           
            mes = "0"+String.valueOf(comboMes.getSelectedIndex()+1);
            
        }else{
            
            mes = String.valueOf(comboMes.getSelectedIndex()+1);
            
        }
        
        if(comboDia.getSelectedItem().toString().length() == 1){
            
            dia = "0" + comboDia.getSelectedItem().toString();
            
        }else{
            
            dia = comboDia.getSelectedItem().toString();
            
        }
        
        int anioSeleccionado = Integer.parseInt(anio);
        
        int mesSeleccionado = Integer.parseInt(mes);
        
        int diaSeleccionado = Integer.parseInt(dia);

        if(diaSeleccionado <= diaHoy && mesSeleccionado <= mesHoy && anioSeleccionado <= anioHoy){
            
            agregar = true;
            
            return anio + "-" + mes + "-" + dia;
            
        }else{
            
            comboAnio.setSelectedItem(String.valueOf(anioHoy));
            
            comboMes.setSelectedIndex(mesHoy-1);
            
            comboDia.setSelectedIndex(diaHoy-1);
            
            agregar = false;
            
            if(String.valueOf(mesHoy).length() == 1){
           
                mes = "0"+String.valueOf(mesHoy);

            }else{

                mes = String.valueOf(mesHoy);

            }

            if(String.valueOf(diaHoy).length() == 1){

                dia = "0" + String.valueOf(diaHoy);

            }else{

                dia = String.valueOf(diaHoy);

            }
            
            JOptionPane.showMessageDialog(internal, "Fecha invalida");
            
            System.err.println(anioHoy + "-" + mes + "-" + dia);
            
            return anioHoy + "-" + mes + "-" + dia;
            
        }
        
    }
    
    public static void camposVacios(JInternalFrame internal, JComponent... compoentes){
        
        agregar = true;
        
        int contadorCampos = 0;
        
        for(JComponent c : compoentes){
            
            if(c instanceof JTextField){
                
                if(((JTextField) c).getText().isEmpty()){
                    
                    contadorCampos++;
                    
                }
                
            }

        }
        
        if(contadorCampos > 0){
            
            JOptionPane.showMessageDialog(internal, "Tienes " + contadorCampos + " campos vacios, verificalos");
            
            agregar = false;
            
        }
        
    }
    
    public static boolean sePuedeAgregar(){
 
        return agregar;
      
    }
    
    public static void validarNumerosEnteros(JTextField caja, JInternalFrame internal){
        
        String ultimoElemento;
        
        String cadena = caja.getText();
        
        
        int numeroCaracteres = (caja.getText().length());
 
        
        if(numeroCaracteres == 0){
            
            ultimoElemento = null;
            
        }else{
       
            ultimoElemento = String.valueOf(caja.getText().charAt(numeroCaracteres-1));
            
        }
        

        
        
        if(ultimoElemento != null){
            
            if((ultimoElemento.codePointAt(0) >= 48 && ultimoElemento.codePointAt(0) <= 57)){        
            

            
            }else{

                JOptionPane.showMessageDialog(internal, "Solo puedes ingresar numéros");

                caja.setText(cadena.substring(0, cadena.length()-1));

            }
            
        }
        
    }
    
    public static void contarCaracteres(JTextField caja){
        
        String cadena = caja.getText();
        
        if(cadena.length() <= 6){
            
            
            
        }else{
         

            caja.setText(cadena.substring(0, cadena.length()-1));
            
        }
        
        
    }
    
}
