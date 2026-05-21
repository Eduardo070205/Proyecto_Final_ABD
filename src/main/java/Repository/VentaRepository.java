/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import BD.ConexionBD;
import Modelo.Venta;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta obtenerPorId(int idVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
