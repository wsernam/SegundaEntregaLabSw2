package co.edu.unicauca.mvc.vistas.articulos;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 * Ventana interna para listar artículos.
 * Permite visualizar, actualizar, eliminar y asignar revisores a los artículos.
 * 
 */
public class VtnListarArticulos extends javax.swing.JInternalFrame {

    /**
     * Crea una nueva instancia de la ventana de listar artículos.
     *
     * @param objServicio Servicio para el manejo de artículos
     * @param objServicio2 Servicio para el manejo de conferencias
     * @param objServicio3 Servicio para el manejo de revisores
     */

    /**
     * Inicializa la tabla para listar los artículos.
     * Se configuran las columnas que se mostrarán en la tabla.
     */

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
     * Llena la tabla con los artículos disponibles.
     * Obtiene la lista de artículos del servicio y los añade a la tabla.
     */

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
        jButtonEvaluar = new javax.swing.JButton();

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

        jButtonEvaluar.setText("Evaluar");
        jButtonEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEvaluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButtonActalizar)
                .addGap(109, 109, 109)
                .addComponent(jButtonEvaluar)
                .addGap(109, 109, 109)
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
                    .addComponent(jButtonRegistrar)
                    .addComponent(jButtonEvaluar))
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

    }//GEN-LAST:event_jButtonActalizarActionPerformed

    /**
     * Maneja el evento de clic en el botón de registrar.
     *
     * @param evt Evento de clic en el botón de registrar
     */
    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    /**
     * Maneja el evento de clic en la tabla para realizar acciones específicas 
     * según la opción seleccionada en la fila.
     *
     * @param evt Evento de clic en la tabla
     */
    private void jTableListarArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarArticulosMouseClicked

    }//GEN-LAST:event_jTableListarArticulosMouseClicked
    
    /**
     * Maneja el evento de clic en el botón de evaluar.
     *
     * @param evt Evento de clic en el botón de evaluar
     */
    private void jButtonEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEvaluarActionPerformed

    }//GEN-LAST:event_jButtonEvaluarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActalizar;
    private javax.swing.JButton jButtonEvaluar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarArticulos;
    // End of variables declaration//GEN-END:variables
}
