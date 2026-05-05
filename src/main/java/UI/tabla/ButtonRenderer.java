/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.tabla;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

// SRP: solo se encarga de renderizar el botón en la celda
public class ButtonRenderer extends JButton implements TableCellRenderer {

    
    public ButtonRenderer(ImageIcon icono) {
        setIcon(icono);
        setText("");
        setBackground(new java.awt.Color(227, 211, 163));
        setBorderPainted(false);
        setContentAreaFilled(false); 
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}