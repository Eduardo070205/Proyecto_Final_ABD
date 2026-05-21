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
        String sql = """
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo AS Nombre,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            """;

        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Vehiculo(
                    rs.getString("ID_Vehiculo"),
                    rs.getString("Numero_Serie"),
                    rs.getString("Nombre"),
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

        String sql = """
            INSERT INTO Vehiculos (
                ID_Vehiculo,
                Numero_Serie,
                ID_Modelo,
                Fecha_Fabricacion,
                Precio,
                Kilometraje,
                Fecha_Entrada,
                Tipo,
                Estado
            )
            VALUES (
                ?, 
                ?, 
                (
                    SELECT ID_Modelo
                    FROM Modelos
                    WHERE TRIM(UPPER(Nombre_Modelo)) =
                    TRIM(UPPER(?))
                ),
                ?, ?, ?, ?, ?, ?
            )
            """;

        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, vehiculo.getIdVehiculo());
            ps.setString(2, vehiculo.getNumeroSerie());

            ps.setString(3, vehiculo.getNombreModelo());

            ps.setDate(4, vehiculo.getFechaFabricacion());
            ps.setDouble(5, vehiculo.getPrecio());
            ps.setInt(6, vehiculo.getKilometraje());
            ps.setDate(7, vehiculo.getFechaEntrada());
            ps.setString(8, vehiculo.getTipo());
            ps.setString(9, vehiculo.getEstado());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(
                "Error SQL: " + e.getMessage(), e
            );
        }
    }

    @Override
    public void eliminar(String idVehiculo) {
               
        String sql = "DELETE FROM Vehiculos WHERE ID_Vehiculo = ?";
        
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, idVehiculo);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar vehiculo: " + e.getMessage(), e);
        }
    }

    @Override
    public Vehiculo obtenerPorId(String idVehiculo) {

        String sql = """
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            WHERE v.ID_Vehiculo = ?
            """;

        try {

            Connection con = ConexionBD.getInstancia().getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, idVehiculo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Vehiculo(

                    rs.getString("ID_Vehiculo"),

                    rs.getString("Numero_Serie"),

                    rs.getString("Nombre_Modelo"),

                    rs.getDate("Fecha_Fabricacion"),

                    rs.getDouble("Precio"),

                    rs.getInt("Kilometraje"),

                    rs.getDate("Fecha_Entrada"),

                    rs.getString("Tipo"),

                    rs.getString("Estado")
                );
            }

        } catch (SQLException e) {

            logger.log(
                Level.SEVERE,
                "Error al obtener vehículo: " + e.getMessage(),
                e
            );

            throw new RuntimeException(
                "Error al obtener vehículo: " + e.getMessage()
            );
        }

        return null;
    }

    @Override
    public void actualizar(Vehiculo vehiculo) {
        
        String sql = """
            UPDATE Vehiculos 
            SET 
                Numero_Serie = ?,
                ID_Modelo = (
                    SELECT ID_Modelo
                    FROM Modelos
                    WHERE TRIM(UPPER(Nombre_Modelo)) =
                          TRIM(UPPER(?))
                ),
                Fecha_Fabricacion = ?,
                Precio = ?,
                Kilometraje = ?,
                Fecha_Entrada = ?,
                Tipo = ?,
                Estado = ?
            WHERE ID_Vehiculo = ?
            
            """;

        try {

            Connection con = ConexionBD.getInstancia().getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, vehiculo.getNumeroSerie());

            // Nombre del modelo seleccionado
            ps.setString(2, vehiculo.getNombreModelo());

            ps.setDate(3, vehiculo.getFechaFabricacion());

            ps.setDouble(4, vehiculo.getPrecio());

            ps.setInt(5, vehiculo.getKilometraje());

            ps.setDate(6, vehiculo.getFechaEntrada());

            ps.setString(7, vehiculo.getTipo());

            ps.setString(8, vehiculo.getEstado());

            // ID del vehículo a editar
            ps.setString(9, vehiculo.getIdVehiculo());

            ps.executeUpdate();

        } catch (SQLException e) {

            logger.log(Level.SEVERE,
                "Error al actualizar vehiculo: " + e.getMessage(),
                e
            );

            throw new RuntimeException(
                "Error al actualizar vehículo: " + e.getMessage()
            );
        }

    }

    @Override
    public List<Vehiculo> buscarPorId(String id) {
        return ejecutarQuery("""
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo AS Nombre,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            WHERE v.ID_Vehiculo LIKE ?
            """, "%" + id + "%");
    }

    @Override
    public List<Vehiculo> buscarPorModelo(String modelo) {
        return ejecutarQuery("""
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo AS Nombre,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            WHERE v.ID_Modelo = (SELECT ID_Modelo FROM Modelos WHERE TRIM(UPPER(Nombre_Modelo)) = TRIM(UPPER(?)))
            """, modelo);
    }
        
       

    @Override
    public List<Vehiculo> buscarPorAnioFab(int anio) {
        return ejecutarQuery("""
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo AS Nombre,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            WHERE EXTRACT(YEAR FROM v.Fecha_Fabricacion) = ?
            """, anio);
    }

    @Override
    public List<Vehiculo> buscarPorPrecio(double precio) {
        return ejecutarQuery("""
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo AS Nombre,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            WHERE v.Precio <= ?
            """, precio);
    }

    @Override
    public List<Vehiculo> buscarPorTipo(String tipo) {
        return ejecutarQuery("""
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo AS Nombre,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            WHERE v.Tipo = ?
            """, tipo);
    }

    @Override
    public List<Vehiculo> buscarPorEstado(String estado) {
        return ejecutarQuery("""
            SELECT 
                v.ID_Vehiculo,
                v.Numero_Serie,
                m.Nombre_Modelo AS Nombre,
                v.Fecha_Fabricacion,
                v.Precio,
                v.Kilometraje,
                v.Fecha_Entrada,
                v.Tipo,
                v.Estado
            FROM Vehiculos v
            JOIN Modelos m
                ON v.ID_Modelo = m.ID_Modelo
            WHERE v.Estado = ?
            """, estado);
    }

    private List<Vehiculo> ejecutarQuery(String sql, Object parametro) {
        List<Vehiculo> lista = new ArrayList<>();
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            if (parametro instanceof Integer) {
                ps.setInt(1, (Integer) parametro);
            }else if (parametro instanceof Double) {
            ps.setDouble(1, (Double) parametro); 
            }else {
                ps.setString(1, (String) parametro);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Vehiculo(
                    rs.getString("ID_Vehiculo"),
                    rs.getString("Numero_Serie"),
                    rs.getString("Nombre"),
                    rs.getDate("Fecha_Fabricacion"),
                    rs.getDouble("Precio"),
                    rs.getInt("Kilometraje"),
                    rs.getDate("Fecha_Entrada"),
                    rs.getString("Tipo"),
                    rs.getString("Estado")
                ));
            }
        } catch (SQLException e) {
            logger.log(
                Level.SEVERE,
                "Error al obtener vehículo: " + e.getMessage(),
                e
            );

            throw new RuntimeException(
                "Error al obtener vehículo: " + e.getMessage()
            );
        }
        return lista;
    }
    
}
