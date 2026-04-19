/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author Eduardo
 */
public class LoginController {
    
     public boolean validarCredenciales(String usuario, String contrasena) {
        // Por ahora validación básica, después conectas la BD aquí
        return !usuario.isBlank() && !contrasena.isBlank();
    }
    
}
