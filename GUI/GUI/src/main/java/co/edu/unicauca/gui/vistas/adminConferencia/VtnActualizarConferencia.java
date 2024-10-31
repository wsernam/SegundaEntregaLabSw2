package co.edu.unicauca.gui.vistas.adminConferencia;

import co.edu.unicauca.gui.models.Conferencia;
import co.edu.unicauca.gui.servicios.ConferenciaServices;
import co.edu.unicauca.mvc.utilidades.Utilidades;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sonhuila
 */
public class VtnActualizarConferencia extends javax.swing.JFrame {

    private final ConferenciaServices objConferenciaServices;
    private Integer idConferenciaActual;

    /**
     * Creates new form VtnActualizarConferencia
     *
     * @param objConferenciaServices
     */
    public VtnActualizarConferencia(ConferenciaServices objConferenciaServices) {
        initComponents();
        this.objConferenciaServices = objConferenciaServices;
    }

    public void actualizarFormularioConferencia(Integer idConferenciaActual, Conferencia objConferencia) {
        this.idConferenciaActual = idConferenciaActual;
        this.jTextFieldNombre.setText(objConferencia.getNombre());

        // Configurar el formateador de fecha
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        // Convertir las fechas de Date a String y establecerlas en los campos de texto
        this.jTextFieldFechaInicio.setText(formatter.format(objConferencia.getFechaInicio()));
        this.jTextFieldFechaFin.setText(formatter.format(objConferencia.getFechaFin()));
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
        jPanelMedio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 204));
        jLabelTitulo.setText("Actualizar Conferencia");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(40, 40, 40))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelMedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Fecha inicio:");

        jLabel3.setText("Fecha Fin:");

        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMedioLayout = new javax.swing.GroupLayout(jPanelMedio);
        jPanelMedio.setLayout(jPanelMedioLayout);
        jPanelMedioLayout.setHorizontalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMedioLayout.createSequentialGroup()
                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMedioLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelMedioLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelMedioLayout.createSequentialGroup()
                                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFechaInicio)
                                    .addComponent(jTextFieldFechaFin)))))
                    .addGroup(jPanelMedioLayout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelMedioLayout.setVerticalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMedioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelMedio, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // Recoger los datos de la interfaz gráfica
        String nombre = jTextFieldNombre.getText();
        String fechaInicio = jTextFieldFechaInicio.getText();
        String fechaFin = jTextFieldFechaFin.getText();
        Integer idConferenciaEntero = this.idConferenciaActual; // Asumiendo que el ID de la conferencia actual está en la variable idConferenciaActual

        // Validación de datos de entrada
        if (nombre.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty()) {
            Utilidades.mensajeAdvertencia("Por favor, complete todos los campos", "Campos incompletos");
            return;
        }

        // Convertir fechas de String a Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicioDate = null;
        Date fechaFinDate = null;

        try {
            fechaInicioDate = formatter.parse(fechaInicio);
            fechaFinDate = formatter.parse(fechaFin);
        } catch (Exception ex) {
            Utilidades.mensajeAdvertencia("La fecha ingresada no sigue el formato dd/MM/yyyy", "Formato de fecha incorrecto");
            return; // Termina el método si hay un error de formato
        }

        // Crear el objeto Conferencia con las fechas convertidas
        Conferencia objConferencia = new Conferencia(nombre, fechaInicioDate, fechaFinDate);

        // Verificar si la conferencia existe antes de actualizar
        if (!this.objConferenciaServices.consultarSiExisteConferencia(idConferenciaEntero)) {
            Utilidades.mensajeError("Error, la conferencia no está registrada", "Error al actualizar la conferencia");
        } else {
            // Actualizar la conferencia existente
            Conferencia objConferenciaActualizada = this.objConferenciaServices.actualizarConferencia(objConferencia, idConferenciaEntero);
            if (objConferenciaActualizada != null) {
                Utilidades.mensajeExito("Conferencia actualizada exitosamente", "Conferencia actualizada");
            } else {
                Utilidades.mensajeError("Error al actualizar la conferencia", "Error de actualización");
            }
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelMedio;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
