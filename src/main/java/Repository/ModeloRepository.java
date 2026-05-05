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

    @Override
    public void agregar(Modelo modelo) {
    
        String sql = "INSERT INTO Modelos (Nombre_Modelo, Anio_Modelo, Fabricante, " +
                 "Numero_Cilindros, Numero_Puertas, Peso_Kg, Capacidad_Pasajeros, " +
                 "Color_Base, Pais_Fabricacion) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombreModelo());
            ps.setInt(2, modelo.getAnioModelo());
            ps.setString(3, modelo.getFabricante());
            ps.setInt(4, modelo.getNumeroCilindros());
            ps.setInt(5, modelo.getNumeroPuertas());
            ps.setDouble(6, modelo.getPesoKg());
            ps.setInt(7, modelo.getCapacidadPasajeros());
            ps.setString(8, modelo.getColorBase());
            ps.setString(9, modelo.getPaisFabricacion());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al agregar modelo: " + e.getMessage(), e);
        }
        
    }    
    
    @Override
    public void eliminar(int idModelo) {
        String sql = "DELETE FROM Modelos WHERE ID_Modelo = ?";
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idModelo);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar modelo: " + e.getMessage(), e);
        }
    }

    @Override
    public Modelo obtenerPorId(int idModelo) {
        String sql = "SELECT * FROM Modelos WHERE ID_Modelo = ?";
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idModelo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Modelo(
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
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener modelo: " + e.getMessage(), e);
        }
        return null;
    }
    
    @Override
    public void actualizar(Modelo modelo) {
        String sql = "UPDATE Modelos SET Nombre_Modelo = ?, Anio_Modelo = ?, Fabricante = ?, " +
                     "Numero_Cilindros = ?, Numero_Puertas = ?, Peso_Kg = ?, " +
                     "Capacidad_Pasajeros = ?, Color_Base = ?, Pais_Fabricacion = ? " +
                     "WHERE ID_Modelo = ?";
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombreModelo());
            ps.setInt(2, modelo.getAnioModelo());
            ps.setString(3, modelo.getFabricante());
            ps.setInt(4, modelo.getNumeroCilindros());
            ps.setInt(5, modelo.getNumeroPuertas());
            ps.setDouble(6, modelo.getPesoKg());
            ps.setInt(7, modelo.getCapacidadPasajeros());
            ps.setString(8, modelo.getColorBase());
            ps.setString(9, modelo.getPaisFabricacion());
            ps.setInt(10, modelo.getIdModelo());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar modelo: " + e.getMessage(), e);
        }
    }
    
    @Override
    public List<Modelo> buscarPorId(int id) {
        return ejecutarQuery("SELECT * FROM Modelos WHERE ID_Modelo = ?", id);
    }

    @Override
    public List<Modelo> buscarPorNombre(String nombre) {
        return ejecutarQuery("SELECT * FROM Modelos WHERE UPPER(Nombre_Modelo) LIKE UPPER(?)", "%" + nombre + "%");
    }

    @Override
    public List<Modelo> buscarPorAnio(int anio) {
        return ejecutarQuery("SELECT * FROM Modelos WHERE Anio_Modelo = ?", anio);
    }

    @Override
    public List<Modelo> buscarPorFabricante(String fabricante) {
        return ejecutarQuery("SELECT * FROM Modelos WHERE UPPER(Fabricante) LIKE UPPER(?)", "%" + fabricante + "%");
    }

    @Override
    public List<Modelo> buscarPorCilindros(int cilindros) {
        return ejecutarQuery("SELECT * FROM Modelos WHERE Numero_Cilindros = ?", cilindros);
    }

    @Override
    public List<Modelo> buscarPorPais(String pais) {
        return ejecutarQuery("SELECT * FROM Modelos WHERE UPPER(Pais_Fabricacion) LIKE UPPER(?)", "%" + pais + "%");
    }

    // Método privado para no repetir código — SRP
    private List<Modelo> ejecutarQuery(String sql, Object parametro) {
        List<Modelo> lista = new ArrayList<>();
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            if (parametro instanceof Integer) {
                ps.setInt(1, (Integer) parametro);
            } else {
                ps.setString(1, (String) parametro);
            }
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
            logger.log(Level.SEVERE, "Error en búsqueda: " + e.getMessage(), e);
        }
        return lista;
    }
     
}