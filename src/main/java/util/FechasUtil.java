/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.JComboBox;

/**
 *
 * @author Eduardo
 */

//Clase para configurar las fechas
public class FechasUtil {
    
    public static void cargarDias(JComboBox comboAnio,
                              JComboBox comboMes,
                              JComboBox comboDia) {

        if (comboAnio.getSelectedItem() == null || comboMes.getSelectedItem() == null) {
            return; 
        }

        comboDia.removeAllItems();

        int anio = Integer.parseInt(comboAnio.getSelectedItem().toString());
        String mes = comboMes.getSelectedItem().toString();

        int dias = obtenerDiasDelMes(mes, anio);

        for (int i = 1; i <= dias; i++) {
            comboDia.addItem(i);
        }
    }
    
    private static int obtenerDiasDelMes(String mes, int anio) {

        switch (mes.toLowerCase()) {

            case "enero":
            case "marzo":
            case "mayo":
            case "julio":
            case "agosto":
            case "octubre":
            case "diciembre":
                return 31;

            case "abril":
            case "junio":
            case "septiembre":
            case "noviembre":
                return 30;

            case "febrero":
                return esBisiesto(anio) ? 29 : 28;

            default:
                return 30;
        }
    }
    
    private static boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }
    
}
