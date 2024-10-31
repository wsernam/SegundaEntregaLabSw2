package co.edu.unicauca.gui.vistas.articulos;

import co.edu.unicauca.gui.models.Articulo;
import co.edu.unicauca.gui.servicios.ArticuloServices;
import co.edu.unicauca.gui.servicios.ConferenciaServices;
import co.edu.unicauca.mvc.utilidades.Utilidades;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana interna para listar artículos. Permite visualizar, actualizar,
 * eliminar y asignar revisores a los artículos.
 *
 */
public class VtnListarArticulos extends javax.swing.JInternalFrame {

    public ArticuloServices objServicio; // Servicio para manejar artículos
    public ConferenciaServices objServicio2; // Servicio para manejar conferencias

    /**
     * Crea una nueva instancia de la ventana de listar artículos.
     *
     * @param objServicio Servicio para el manejo de artículos
     * @param objServicio2 Servicio para el manejo de conferencias
     */
    public VtnListarArticulos(
            ArticuloServices objServicio,
            ConferenciaServices objServicio2) {
        initComponents();
        this.objServicio = objServicio;
        this.objServicio2 = objServicio2;
        this.jTableListarArticulos.setDefaultRenderer(Object.class, new Render());
        inicializarTabla();
    }

    /**
     * Inicializa la tabla para listar los artículos. Se configuran las columnas
     * que se mostrarán en la tabla.
     */
    private void inicializarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Titulo");
        model.addColumn("Autores");
        model.addColumn("Eliminar");
        model.addColumn("Actualizar");
        this.jTableListarArticulos.setModel(model);
    }

    /**
     * Limpia las filas de la tabla.
     */
    public void limpiarTabla() {

        DefaultTableModel modelo = (DefaultTableModel) this.jTableListarArticulos.getModel();
        int filas = this.jTableListarArticulos.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }

    /**
     * Llena la tabla con los artículos disponibles. Obtiene la lista de
     * artículos del servicio y los añade a la tabla.
     */
    private void llenarTabla() {
        DefaultTableModel model = (DefaultTableModel) this.jTableListarArticulos.getModel();
        limpiarTabla();
        // Obtener la lista de artículos desde el servicio
        ArrayList<Articulo> listaArticulos = (ArrayList<Articulo>) this.objServicio.listarArticulos();

        // Crear los botones con íconos
        JButton JButtonEliminarArticulo = new JButton();
        JButtonEliminarArticulo.setName("Eliminar");
        JButtonEliminarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png")));

        JButton JButtonActualizarArticulo = new JButton();
        JButtonActualizarArticulo.setName("Actualizar");
        JButtonActualizarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/lapiz.png")));

        // Iterar a través de la lista de artículos y agregar cada fila a la tabla
        for (Articulo articulo : listaArticulos) {
            Object[] fila = new Object[]{
                articulo.getIdArticulo(),
                articulo.getTitulo(),
                articulo.getAutores(), // Cambia esto según lo que necesitas mostrar
                JButtonEliminarArticulo,
                JButtonActualizarArticulo
            };
            model.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarArticulos = new javax.swing.JTable();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonActalizar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Gestionar articulos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 0, 153));

        jTableListarArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableListarArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarArticulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListarArticulos);

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonActalizar.setText("Actualizar");
        jButtonActalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButtonActalizar)
                .addGap(290, 290, 290)
                .addComponent(jButtonRegistrar)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActalizar)
                    .addComponent(jButtonRegistrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón de actualizar.
     *
     * @param evt Evento de clic en el botón de actualizar
     */
    private void jButtonActalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActalizarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_jButtonActalizarActionPerformed

    /**
     * Maneja el evento de clic en el botón de registrar.
     *
     * @param evt Evento de clic en el botón de registrar
     */
    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        VtnRegistrarArticulo1 objVtnRegistrarArticulo = new VtnRegistrarArticulo1(objServicio, objServicio2);
        JDialog dialog = new JDialog((JFrame) null, "Registrar Artículo", true);
        dialog.getContentPane().add(objVtnRegistrarArticulo.getContentPane());
        dialog.pack();
        dialog.setLocationRelativeTo(null);  // Para centrar la ventana
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    /**
     * Maneja el evento de clic en la tabla para realizar acciones específicas
     * según la opción seleccionada en la fila.
     *
     * @param evt Evento de clic en la tabla
     */
    private void jTableListarArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarArticulosMouseClicked

        int column = this.jTableListarArticulos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jTableListarArticulos.getRowHeight();

        if (row < jTableListarArticulos.getRowCount() && row >= 0 && column < jTableListarArticulos.getColumnCount() && column >= 0) {
            Object value = jTableListarArticulos.getValueAt(row, column);

            if (value instanceof JButton) {

                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                String idArticuloStr = jTableListarArticulos.getValueAt(row, 0).toString();

                if ("Eliminar".equals(boton.getName())) {
                    this.eliminarArticulo(idArticuloStr);
                } else if ("Actualizar".equals(boton.getName())) {
                    System.out.println("SSs");
                    this.actualizarArticulo(idArticuloStr);
                }
            }
        }
    }//GEN-LAST:event_jTableListarArticulosMouseClicked

    private void actualizarArticulo(String idArticulo) {
        int idArticuloEntero = Integer.parseInt(idArticulo);
        Articulo objArticulo = this.objServicio.consultarArticulo(idArticuloEntero);
        VtnActualizarArticulo vtnActualizarArticulo = new VtnActualizarArticulo(this.objServicio, objServicio2);
        vtnActualizarArticulo.actualizarFormularioArticulo(idArticuloEntero, objArticulo);
        vtnActualizarArticulo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vtnActualizarArticulo.setVisible(true);
    }

    private void eliminarArticulo(String idArticulo) {
        if (Utilidades.mensajeConfirmacion("¿Estás seguro de que quieres eliminar el artículo con ID " + idArticulo + "?", "Confirmación") == 0) {
            int idArticuloEntero = Integer.parseInt(idArticulo);
            boolean eliminado = this.objServicio.eliminarArticulo(idArticuloEntero);
            if (eliminado) {
                Utilidades.mensajeExito("El artículo con ID " + idArticulo + " fue eliminado exitosamente", "Artículo Eliminado");
                llenarTabla(); // Actualiza la tabla tras eliminar
            } else {
                Utilidades.mensajeAdvertencia("El artículo con ID " + idArticulo + " no fue eliminado", "Error al Eliminar");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActalizar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarArticulos;
    // End of variables declaration//GEN-END:variables
}
