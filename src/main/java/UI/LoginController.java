/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author Eduardo
 */

import BD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public boolean validarCredenciales(String usuario, String contrasena) {
        try {
            Connection con = ConexionBD.conectarUsuario(usuario, contrasena);
            con.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public String obtenerRol(String usuario, String contrasena) {
        String sql = "SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS";
        try {
            Connection con = ConexionBD.conectarUsuario(usuario, contrasena);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("GRANTED_ROLE");
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}