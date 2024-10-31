package co.edu.unicauca.gui.vistas.adminConferencia;

import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import co.edu.unicauca.gui.models.Conferencia;
import co.edu.unicauca.gui.servicios.ConferenciaServices;
import co.edu.unicauca.gui.vistas.articulos.Render;
import co.edu.unicauca.mvc.utilidades.Utilidades;
import java.util.List;
import javax.swing.JButton;

/**
 * Ventana para listar conferencias en el sistema.
 * 
 * Esta clase extiende {@link javax.swing.JInternalFrame} y permite visualizar
 * un listado de conferencias registradas, así como agregar nuevas conferencias
 * mediante una ventana de registro.
 */
public class VtnListarConferencias extends javax.swing.JInternalFrame {

    private ConferenciaServices objServicioAlmacenamiento;
    
    /**
     * Constructor de la clase.
     * 
     * @param objServicioAlmacenamiento Servicio para almacenar conferencias.
     */
    public VtnListarConferencias(ConferenciaServices objServicioAlmacenamiento) {
        initComponents();
        this.objServicioAlmacenamiento=objServicioAlmacenamiento;
        this.jTableListadoConferencias.setDefaultRenderer(Object.class, new Render());
        iniciarlizarTabla();
    }
    
    /**
     * Inicializa la tabla donde se mostrarán las conferencias.
     */
    private void iniciarlizarTabla()
    {
       DefaultTableModel model= new DefaultTableModel();       
       model.addColumn("Nombre");       
       model.addColumn("Fecha de inicio");
       model.addColumn("Fecha de fin");
       model.addColumn("actualizar");
       model.addColumn("eliminar");
       this.jTableListadoConferencias.setModel(model);
    }
    
    /**
     * Limpia el contenido de la tabla de conferencias.
     */
    public void limpiarTabla(){
        
        DefaultTableModel modelo=(DefaultTableModel) this.jTableListadoConferencias.getModel();
        int filas=this.jTableListadoConferencias.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }        
    }
    
    /**
     * Llena la tabla con la lista de conferencias almacenadas.
     */
private void llenarTabla() {
    DefaultTableModel model = (DefaultTableModel) this.jTableListadoConferencias.getModel();
    limpiarTabla();
    List<Conferencia> listaConferencias = this.objServicioAlmacenamiento.listarConferencias();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    for (int i = 0; i < listaConferencias.size(); i++) {
        JButton JButtonActualizarConferencia = new JButton();
        JButtonActualizarConferencia.setName("Actualizar");
        JButtonActualizarConferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/lapiz.png")));

        JButton JButtonEliminarConferencia = new JButton();
        JButtonEliminarConferencia.setName("Eliminar");
        JButtonEliminarConferencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png")));

        // Verificar que las fechas no sean null antes de formatearlas
        String fechaInicioFormateada = listaConferencias.get(i).getFechaInicio() != null 
            ? formatter.format(listaConferencias.get(i).getFechaInicio()) 
            : "Fecha no disponible";
        
        String fechaFinFormateada = listaConferencias.get(i).getFechaFin() != null 
            ? formatter.format(listaConferencias.get(i).getFechaFin()) 
            : "Fecha no disponible";

        Object[] fila = {
            listaConferencias.get(i).getNombre(), 
            fechaInicioFormateada,
            fechaFinFormateada,
            JButtonActualizarConferencia, 
            JButtonEliminarConferencia
        };
        
        model.addRow(fila);
    }  
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelInferior = new javax.swing.JPanel();
        jPanelCentral = new javax.swing.JPanel();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListadoConferencias = new javax.swing.JTable();

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 51, 204));
        jLabelTitulo.setText("Listado de conferencias");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabelTitulo)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelTitulo)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/agregar.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar conferencia");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/print.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jTableListadoConferencias.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableListadoConferencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoConferenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListadoConferencias);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButtonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrar)
                    .addComponent(jButtonActualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
       llenarTabla();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        VtnRegistrarConferencia objVtnRegistrarConferencia= 
                new VtnRegistrarConferencia(this.objServicioAlmacenamiento);
        objVtnRegistrarConferencia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        objVtnRegistrarConferencia.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jTableListadoConferenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoConferenciasMouseClicked
       int column = this.jTableListadoConferencias.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableListadoConferencias.getRowHeight();
        
        if(row < jTableListadoConferencias.getRowCount() && row >= 0 && column < jTableListadoConferencias.getColumnCount() && column >= 0){
            Object value = jTableListadoConferencias.getValueAt(row, column);
            
            if(value instanceof JButton){
                
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                String idCliente = jTableListadoConferencias.getValueAt(row, 0).toString();
               
                if(boton.getName().equals("Eliminar")){
                   this.elimininarCliente(idCliente);
                }
                else if(boton.getName().equals("Actualizar")){
                   this.actualizarConferencia(idCliente);
                }
            }
        } 
    }//GEN-LAST:event_jTableListadoConferenciasMouseClicked
    private void actualizarConferencia(String idConferencia)
    {
        Integer idConferenciaEntero=Integer.valueOf(idConferencia);
        Conferencia objCliente= this.objServicioAlmacenamiento.consultarConferencia(idConferenciaEntero);
        VtnActualizarConferencia vtnObjActualizarConferencia= new VtnActualizarConferencia(this.objServicioAlmacenamiento);
        vtnObjActualizarConferencia.actualizarFormularioConferencia(idConferenciaEntero, objCliente);
        vtnObjActualizarConferencia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vtnObjActualizarConferencia.setVisible(true);
    }
    
    private void elimininarCliente(String idConferencia)
    {
        try{  
                if(Utilidades.mensajeConfirmacion("� Estas seguro de que quieres eliminar al cliente con id " + idConferencia + " " 
                    +" ?", "Confirmacion") == 0){
                   Integer idConferenciaEntero=Integer.valueOf(idConferencia); 
                   boolean bandera=this.objServicioAlmacenamiento.eliminarConferencia(idConferenciaEntero);
                   if(bandera==true)
                   {
                       Utilidades.mensajeExito("La conferencia con id " + idConferencia + " fue eliminado exitosamente", "Cliente eliminado");
                       llenarTabla();
                   }
                   else
                   {
                       Utilidades.mensajeAdvertencia("La conferencia con id " + idConferencia + " no fue eliminada", "Error al eliminar");

                   }
                }
            }catch(Exception ex){
                Utilidades.mensajeError("Error al eliminar la conferencia. Intentelo de nuevo mas tarde", "Error");
        }  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListadoConferencias;
    // End of variables declaration//GEN-END:variables
}
