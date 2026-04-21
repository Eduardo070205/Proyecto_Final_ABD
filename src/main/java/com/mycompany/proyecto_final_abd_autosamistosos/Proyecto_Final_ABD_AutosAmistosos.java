/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final_abd_autosamistosos;

import BD.ConexionBD;
import UI.VentanaLogin;
import java.sql.Connection;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eduardo
 */
public class Proyecto_Final_ABD_AutosAmistosos {

    public static void main(String[] args) {
        
        Connection con = ConexionBD.getInstancia().getConnection();
        
        if (con != null) {
            System.out.println("Conexión exitosa");
        } else {
            System.out.println("Falló la conexión");
        }
       
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new VentanaLogin();

            }
        });
        
        
    }
}
