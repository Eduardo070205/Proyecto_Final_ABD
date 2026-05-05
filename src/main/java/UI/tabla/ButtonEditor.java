/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.tabla;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionListener;

// SRP: solo se encarga de manejar el clic del botón en la celda
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

   private final JButton boton;

    public ButtonEditor(ImageIcon icono, ActionListener accion) {
        boton = new JButton();
        boton.setIcon(icono);
        boton.setText(""); // sin texto
        boton.setBackground(new java.awt.Color(227, 211, 163));
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false); // transparente
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.addActionListener(e -> {
            fireEditingStopped();
            accion.actionPerformed(e);
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        return boton;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }
}