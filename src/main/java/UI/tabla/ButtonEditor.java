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
    private final ActionListener accion;

    public ButtonEditor(String texto, ActionListener accion) {
        this.accion = accion;
        boton = new JButton(texto);
        boton.setBackground(new java.awt.Color(227, 211, 163));
        boton.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        boton.setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1, true));
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
        return boton.getText();
    }
}