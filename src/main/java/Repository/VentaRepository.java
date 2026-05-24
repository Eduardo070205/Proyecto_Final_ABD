/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import BD.ConexionBD;
import Modelo.Venta;
import java.sql.CallableStatement;
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
public class VentaRepository implements IVentaRepository{
    
    private static final Logger logger = Logger.getLogger(VentaRepository.class.getName());

    @Override
    public List<Venta> obtenerTodos() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT v.ID_Venta, v.Fecha_Venta, v.Precio_Final, v.Forma_Pago, " +
                     "v.ID_Cliente, v.ID_Empleado, m.Nombre_Modelo AS Modelo FROM Ventas v "
                + "JOIN Vehiculos c ON v.ID_Vehiculo = c.ID_Vehiculo JOIN Modelos m ON "
                + "m.ID_Modelo = c.ID_Modelo";

        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Venta(
                    rs.getInt("ID_Venta"),
                    rs.getDate("Fecha_Venta"),
                    rs.getDouble("Precio_Final"),
                    rs.getString("Forma_Pago"),
                    rs.getString("ID_Cliente"),
                    rs.getString("ID_Empleado"),
                    rs.getString("Modelo")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener modelos: " + e.getMessage(), e);
        }

        return lista;
    }

    @Override
    public void agregar(Venta venta) {
        
        String sql = """
            INSERT INTO Ventas (
                Fecha_Venta,
                Forma_Pago,
                Precio_Final,
                ID_Cliente,
                ID_Empleado,
                ID_Vehiculo
            )
            VALUES (
                ?, 
                ?, 
                ?, 
                ?, 
                ?, 
                ?
            )
            """;

        try {

            Connection con = ConexionBD.getInstancia().getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, venta.getFechaVenta());

            ps.setString(2, venta.getFormaPago());

            ps.setDouble(3, venta.getPrecioFinal());

            ps.setString(4, venta.getIdCliente());

            ps.setString(5, venta.getIdEmpleado());

            // Nombre del vehículo/modelo
            ps.setString(6, venta.getNombreVehiculo());

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(
                "Error SQL: " + e.getMessage(),
                e
            );
        }
        
        
    }

    @Override
    public void eliminar(int idVenta) {

        String sql = "DELETE FROM Ventas WHERE ID_Venta = ?";
        
        try {
            Connection con = ConexionBD.getInstancia().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar venta: " + e.getMessage(), e);
        }
        
    }

    public Venta obtenerPorId(int idVenta) {

        String sql = """
            SELECT 
                ID_Venta,
                Fecha_Venta,              
                Precio_Final,
                Forma_Pago,
                ID_Cliente,
                ID_Empleado,
                ID_Vehiculo
            FROM Ventas
            WHERE ID_Venta = ?
            """;

        try {

            Connection con = ConexionBD.getInstancia().getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idVenta);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Venta(

                    rs.getInt("ID_Venta"),

                    rs.getDate("Fecha_Venta"),

                    rs.getDouble("Precio_Final"),
                        
                    rs.getString("Forma_Pago"),

                    rs.getString("ID_Cliente"),

                    rs.getString("ID_Empleado"),

                    rs.getString("ID_Vehiculo")
                );
            }

        } catch (SQLException e) {

            logger.log(
                Level.SEVERE,
                "Error al obtener venta: " + e.getMessage(),
                e
            );

            throw new RuntimeException(
                "Error al obtener venta: " + e.getMessage()
            );
        }

        return null;
    }

    @Override
    public void actualizar(Venta venta) {

        String sql = """
            UPDATE Ventas
            SET
                Fecha_Venta = ?,
                Forma_Pago = ?,
                Precio_Final = ?,
                ID_Cliente = ?,
                ID_Empleado = ?,
                ID_Vehiculo = ?
            WHERE ID_Venta = ?
            """;

        try {

            Connection con = ConexionBD.getInstancia().getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, venta.getFechaVenta());

            ps.setString(2, venta.getFormaPago());

            ps.setDouble(3, venta.getPrecioFinal());

            ps.setString(4, venta.getIdCliente());

            ps.setString(5, venta.getIdEmpleado());

            // ID del vehículo
            ps.setString(6, venta.getNombreVehiculo());

            // ID de la venta a editar
            ps.setInt(7, venta.getIdVenta());

            ps.executeUpdate();

        } catch (SQLException e) {

            logger.log(
                Level.SEVERE,
                "Error al actualizar venta: " + e.getMessage(),
                e
            );

            throw new RuntimeException(
                "Error al actualizar venta: " + e.getMessage()
            );
        }
    }

    @Override
    public List<Venta> buscarPorId(int idVenta) {

        String sql = """
            SELECT 
                v.ID_Venta,
                v.Fecha_Venta,
                v.Forma_Pago,
                v.Precio_Final,
                v.ID_Cliente,
                v.ID_Empleado,
                m.Nombre_Modelo AS ID_Vehiculo
            FROM Ventas v, Vehiculos vh, Modelos m
            WHERE v.ID_Vehiculo = vh.ID_Vehiculo
            AND vh.ID_Modelo = m.ID_Modelo
            AND v.ID_Venta = ?
            """;

        return ejecutarQuery(sql, idVenta);
    }

    @Override

    public List<Venta> buscarPorMes(String mes) {
        String sql = """
            SELECT 
                v.ID_Venta,
                v.Fecha_Venta,
                v.Forma_Pago,
                v.Precio_Final,
                v.ID_Cliente,
                v.ID_Empleado,
                m.Nombre_Modelo AS ID_Vehiculo
            FROM Ventas v, Vehiculos vh, Modelos m
            WHERE v.ID_Vehiculo = vh.ID_Vehiculo
            AND vh.ID_Modelo = m.ID_Modelo
            AND EXTRACT(MONTH FROM v.Fecha_Venta) = ?
            """;
        return ejecutarQuery(sql, Integer.parseInt(mes));
    }

    @Override
    public List<Venta> buscarPorPrecio(String precio) {
        String sql = """
            SELECT 
                v.ID_Venta,
                v.Fecha_Venta,
                v.Forma_Pago,
                v.Precio_Final,
                v.ID_Cliente,
                v.ID_Empleado,
                m.Nombre_Modelo AS ID_Vehiculo
            FROM Ventas v, Vehiculos vh, Modelos m
            WHERE v.ID_Vehiculo = vh.ID_Vehiculo
            AND vh.ID_Modelo = m.ID_Modelo
            AND v.Precio_Final <= ?
            """;
        return ejecutarQuery(sql, Double.parseDouble(precio));
    }

    @Override
    public List<Venta> buscarPorFormaPago(String formaPago) {
        String sql = """
            SELECT 
                v.ID_Venta,
                v.Fecha_Venta,
                v.Forma_Pago,
                v.Precio_Final,
                v.ID_Cliente,
                v.ID_Empleado,
                m.Nombre_Modelo AS ID_Vehiculo
            FROM Ventas v, Vehiculos vh, Modelos m
            WHERE v.ID_Vehiculo = vh.ID_Vehiculo
            AND vh.ID_Modelo = m.ID_Modelo
            AND TRIM(UPPER(v.Forma_Pago)) LIKE TRIM(UPPER(?))
            """;
        return ejecutarQuery(sql, "%" + formaPago + "%");
    }

    @Override
    public List<Venta> buscarPorVehiculo(String vehiculo) {
        String sql = """
            SELECT 
                v.ID_Venta,
                v.Fecha_Venta,
                v.Forma_Pago,
                v.Precio_Final,
                v.ID_Cliente,
                v.ID_Empleado,
                m.Nombre_Modelo AS ID_Vehiculo
            FROM Ventas v
            JOIN Vehiculos vh 
            ON v.ID_Vehiculo = vh.ID_Vehiculo
            JOIN Modelos m
            ON vh.ID_Modelo = m.ID_Modelo         
            WHERE v.ID_Vehiculo = ?
                  
            """;
        return ejecutarQuery(sql, vehiculo);
    }


    
    private List<Venta> ejecutarQuery(String sql, Object parametro) {

        List<Venta> lista = new ArrayList<>();

        try {

            Connection con = ConexionBD.getInstancia().getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            if (parametro instanceof Integer) {

                ps.setInt(1, (Integer) parametro);

            } else if (parametro instanceof Double) {

                ps.setDouble(1, (Double) parametro);

            } else {

                ps.setString(1, (String) parametro);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                lista.add(

                    new Venta(

                        rs.getInt("ID_Venta"),

                        rs.getDate("Fecha_Venta"),

                        rs.getDouble("Precio_Final"),
                            
                        rs.getString("Forma_Pago"),

                        rs.getString("ID_Cliente"),

                        rs.getString("ID_Empleado"),

                        rs.getString("ID_Vehiculo")
                    )
                );
            }

        } catch (SQLException e) {

            logger.log(
                Level.SEVERE,
                "Error al obtener ventas: " + e.getMessage(),
                e
            );

            throw new RuntimeException(
                "Error al obtener ventas: " + e.getMessage()
            );
        }

        return lista;
    }

    public double calcularDescuento(double precio, String formaPago) {

        String sql =
            "{call CalcularDescuento(?, ?, ?)}";

        try {

            Connection con =
                ConexionBD.getInstancia()
                    .getConnection();

            CallableStatement cs =
                con.prepareCall(sql);

            cs.setDouble(1, precio);

            cs.setString(2, formaPago);

            cs.registerOutParameter(
                3,
                java.sql.Types.DOUBLE
            );

            cs.execute();

            return cs.getDouble(3);

        } catch (SQLException e) {

            e.printStackTrace();

            throw new RuntimeException(
                "Error al calcular descuento"
            );
        }
    }


    
    
}
