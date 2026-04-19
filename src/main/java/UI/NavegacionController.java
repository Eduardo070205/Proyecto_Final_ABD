/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import javax.swing.*;


/**
 *
 * @author Eduardo
 */
public class NavegacionController {
    
    public void mostrarPanel(JInternalFrame visible, JInternalFrame... otros) {
        for (JInternalFrame f : otros) f.setVisible(false);
        visible.setVisible(true);
        visible.toFront();
    }

    public void marcarBotonActivo(JButton activo, JButton... resto) {
        activo.setBackground(new java.awt.Color(214, 198, 152));
        for (JButton b : resto) b.setBackground(new java.awt.Color(227, 211, 163));
    }
    
}
