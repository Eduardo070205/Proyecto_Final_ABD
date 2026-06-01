/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Eduardo
 */

//Clase para solo restablecer componentes
public class RestablecerUtil {
    
        public static void restablecer(JComponent... componentes){

        for(JComponent c : componentes){

            if(c instanceof JTextField) {

                ((JTextField) c).setText("");

            }
            if(c instanceof JComboBox<?>){

                ((JComboBox<?>) c).setSelectedIndex(0);

            }
            if(c instanceof JRadioButton){

                ((JRadioButton) c).setSelected(true);

            }
            if(c instanceof JSpinner){
                
                ((JSpinner) c).setValue(0);
                
            }

        }

    }
    
}
