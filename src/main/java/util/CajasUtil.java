/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.JComponent;

/**
 *
 * @author Eduardo
 */
public class CajasUtil {
    
        public static void ocultarComponentes(JComponent componente, JComponent... componentes){
    
        componente.setVisible(true);
        
        for(JComponent c : componentes){
            
            c.setVisible(false);
            
        }
        
    }
    
    
    
}
