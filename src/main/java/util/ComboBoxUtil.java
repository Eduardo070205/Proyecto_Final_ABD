/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Eduardo
 */
public class ComboBoxUtil {
    
    private ComboBoxUtil() {} 

    public static List<Integer> getAnios() {
        List<Integer> anios = new ArrayList<>();
        int anioActual = LocalDate.now().getYear();
        for (int i = anioActual; i >= 1900; i--) {
            anios.add(i);
        }
        return anios;
    }

    public static List<Integer> getCilindros() {
        return List.of(2, 3, 4, 5, 6, 8, 10, 12, 16);
    }
    
}
