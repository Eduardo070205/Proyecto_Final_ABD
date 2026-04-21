/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class ConexionBD {

    private static final Logger logger = Logger.getLogger(ConexionBD.class.getName());

    // Datos de tu Oracle local — ajusta según tu instalación
    private static final String URL      = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String USUARIO  = "bdp_autos_amistosos2";
    private static final String PASSWORD = "1234";

    private static ConexionBD instancia;
    private Connection connection;

    // Constructor privado — nadie puede hacer new ConexionBD() desde afuera
    private ConexionBD() {
        try {
            this.connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            logger.info("Conexión exitosa a Oracle");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al conectar con Oracle: " + e.getMessage(), e);
        }
    }

    // Punto de acceso global a la instancia
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConnection() {
        try {
            // Si la conexión se cayó, reconecta automáticamente
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                logger.info("Reconexión exitosa a Oracle");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al verificar conexión: " + e.getMessage(), e);
        }
        return connection;
    }
}
