/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final_abd_autosamistosos;

import UI.VentanaLogin;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eduardo
 */
public class Proyecto_Final_ABD_AutosAmistosos {

    public static void main(String[] args) {
       
               SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new VentanaLogin();

            }
        });
        
        
    }
}
