/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import BD.ConexionBD;
import Modelo.Modelo;
import Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo
 */
public class VehiculoRepository implements IVehiculoRepository{
    
    private static final Logger logger = Logger.getLogger(VehiculoRepository.class.getName());

    @Override
    public List<Vehiculo> obtenerTodos() {
        
        List<Vehiculo> lista = new ArrayList<>();
        String sql = "SELECT ID_Vehiculo, Numero_Serie, ID_Modelo, Fecha_Fabricacion, " +
                     "Precio, Kilometraje, Fecha_Entrada, " +
                     "Tipo, Estado FROM Vehiculos";

        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Vehiculo(
                    rs.getString("ID_Vehiculo"),
                    rs.getString("Numero_Serie"),
                    rs.getInt("ID_Modelo"),
                    rs.getDate("Fecha_Fabricacion"),
                    rs.getDouble("Precio"),
                    rs.getInt("Kilometraje"),
                    rs.getDate("Fecha_Entrada"),
                    rs.getString("Tipo"),
                    rs.getString("Estado")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener modelos: " + e.getMessage(), e);
        }

        return lista;
       
    }

    @Override
    public void agregar(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(String idVehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Modelo obtenerPorId(String idVehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Modelo> buscarPorId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
