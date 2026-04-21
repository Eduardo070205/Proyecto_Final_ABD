/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import BD.ConexionBD;
import Modelo.Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloRepository implements IModeloRepository {

    private static final Logger logger = Logger.getLogger(ModeloRepository.class.getName());

    @Override
    public List<Modelo> obtenerTodos() {
        List<Modelo> lista = new ArrayList<>();
        String sql = "SELECT ID_Modelo, Nombre_Modelo, Anio_Modelo, Fabricante, " +
                     "Numero_Cilindros, Numero_Puertas, Peso_Kg, " +
                     "Capacidad_Pasajeros, Color_Base, Pais_Fabricacion FROM Modelos";

        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Modelo(
                    rs.getInt("ID_Modelo"),
                    rs.getString("Nombre_Modelo"),
                    rs.getInt("Anio_Modelo"),
                    rs.getString("Fabricante"),
                    rs.getInt("Numero_Cilindros"),
                    rs.getInt("Numero_Puertas"),
                    rs.getDouble("Peso_Kg"),
                    rs.getInt("Capacidad_Pasajeros"),
                    rs.getString("Color_Base"),
                    rs.getString("Pais_Fabricacion")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener modelos: " + e.getMessage(), e);
        }

        return lista;
    }
}