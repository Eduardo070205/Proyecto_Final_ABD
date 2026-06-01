/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import BD.ConexionBD;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Eduardo
 */

//clase para generar el reporte
public class ReporteServiceImplementacion implements ReporteService{

    @Override
    public void generarReporteVentasMes(int mes) {
        
        try {
            
            Connection con = ConexionBD.getInstancia().getConnection();

            Map<String, Object> parametros =
                new HashMap<>();

            parametros.put("MES", mes);

            JasperPrint reporte =
                JasperFillManager.fillReport(
                    "C:\\Users\\eduar\\Documents\\ITSJ\\6. Sexto Semestre\\Administración de Bases de Datos\\Proyecto Final\\Proyecto_Final_ABD_AutosAmistosos\\src\\main\\java\\Reportes\\ReporteVentasMes.jasper",
                    parametros,
                    con
                );

            JasperViewer.viewReport(
                reporte,
                false
            );

        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
}
