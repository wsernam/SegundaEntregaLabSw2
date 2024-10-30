package co.edu.unicauca.gui.vistas.articulos;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase personalizada para renderizar celdas de una tabla que contienen botones.
 * 
 * Esta clase extiende {@link DefaultTableCellRenderer} y permite que
 * las celdas de la tabla que contienen botones cambien su apariencia
 * según su estado (seleccionado o no seleccionado).
 */
public class Render extends DefaultTableCellRenderer {

    /**
     * Constructor de la clase Render.
     */
    public Render() {
    }

    /**
     * Devuelve el componente para renderizar una celda de la tabla.
     * 
     * Este método se sobrescribe para permitir que las celdas que contienen
     * botones cambien su color de fondo y de texto según si están seleccionadas
     * o no. Si el valor de la celda es un {@link JButton}, se configurarán
     * los colores adecuados.
     *
     * @param table La tabla que contiene la celda.
     * @param value El valor de la celda.
     * @param isSelected Indica si la celda está seleccionada.
     * @param hasFocus Indica si la celda tiene el foco.
     * @param row La fila de la celda.
     * @param column La columna de la celda.
     * @return El componente que se mostrará en la celda.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JButton) {
            JButton btn = (JButton) value;
            if (isSelected) {
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            } else {
                btn.setForeground(Color.WHITE);
                btn.setBackground(Color.WHITE);
            }            
            return btn;
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
