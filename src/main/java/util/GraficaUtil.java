/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// util/GraficaUtil.java
package util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Color;
import java.util.Map;

/**
 * SRP: Solo se encarga de construir gráficas.
 */
public class GraficaUtil {

    private GraficaUtil() {}

    public static JFreeChart crearGraficaVentasPorMes(Map<String, Integer> datos, int anio) {
        
        String[] nombresMeses = {"", "Ene", "Feb", "Mar", "Abr", "May", "Jun",
                                      "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agrega los 12 meses aunque no tengan ventas
        for (int i = 1; i <= 12; i++) {
            String key = String.format("%02d", i);
            int total = datos.getOrDefault(key, 0);
            dataset.addValue(total, "Ventas", nombresMeses[i]);
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Ventas por Mes - " + anio,  // título
            "Mes",                         // eje X
            "Número de Ventas",            // eje Y
            dataset,
            PlotOrientation.VERTICAL,
            false,  // leyenda
            true,   // tooltips
            false   // urls
        );

        // Estilo consistente con tu app
        chart.setBackgroundPaint(Color.WHITE);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(247, 227, 178));
        plot.setRangeGridlinePaint(Color.GRAY);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(122, 122, 63));
        renderer.setMaximumBarWidth(0.05);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }
}