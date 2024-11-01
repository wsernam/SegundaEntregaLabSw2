package co.edu.unicauca.gui.vistas.adminConferencia;

import co.edu.unicauca.gui.models.Conferencia;
import co.edu.unicauca.gui.servicios.ConferenciaServices;
import co.edu.unicauca.mvc.utilidades.Utilidades;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingWorker;

/**
 * Ventana para registrar una nueva conferencia en el sistema.
 *
 * Esta clase extiende {@link javax.swing.JFrame} y proporciona la interfaz
 * necesaria para que el administrador ingrese los datos de una conferencia,
 * incluyendo nombre, fechas y costo.
 */
public class VtnRegistrarConferencia extends javax.swing.JFrame {

    private ConferenciaServices objServicioAlmacenamiento;

    /**
     * Constructor de la clase.
     *
     * @param objServicioAlmacenamiento Servicio para almacenar conferencias.
     */
    public VtnRegistrarConferencia(ConferenciaServices objServicioAlmacenamiento) {
        initComponents();
        this.objServicioAlmacenamiento = objServicioAlmacenamiento;
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
        jLabelNombre = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 204));
        jLabelTitulo.setText("Registrar conferencia");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(167, 167, 167))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelNombre.setText("Nombre:");

        jLabelFechaInicio.setText("Fecha Inicio:");

        jLabelFechaFin.setText("Fecha Fin:");

        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/grabar.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFechaFin)
                    .addComponent(jLabelFechaInicio)
                    .addComponent(jLabelNombre))
                .addGap(70, 70, 70)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(jTextFieldFechaInicio))
                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar)
                .addGap(31, 31, 31))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaInicio)
                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaFin)
                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de acción del botón "Registrar".
     *
     * Este método se ejecuta cuando se hace clic en el botón de registro.
     * Obtiene los datos ingresados por el usuario, valida las fechas y el
     * costo, y almacena la nueva conferencia en el sistema.
     *
     * @param evt Evento que desencadena la acción.
     */
    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        jButtonRegistrar.setEnabled(false); // Deshabilitar el botón para evitar múltiples clics

        // Recoger datos de la interfaz gráfica
        String nombre = this.jTextFieldNombre.getText();
        String fechaInicio = this.jTextFieldFechaInicio.getText();
        String fechaFin = this.jTextFieldFechaFin.getText();

        // Validación de datos de entrada
        if (nombre.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty()) {
            Utilidades.mensajeAdvertencia("Por favor, complete todos los campos", "Campos incompletos");
            jButtonRegistrar.setEnabled(true);
            return;
        }

        // Crear un SwingWorker para registrar la conferencia en segundo plano
        SwingWorker<Conferencia, Void> worker = new SwingWorker<Conferencia, Void>() {
            @Override
            protected Conferencia doInBackground() throws Exception {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaInicioDate, fechaFinDate;

                try {
                    // Intentar convertir las fechas y el costo
                    fechaInicioDate = formatter.parse(fechaInicio);
                    fechaFinDate = formatter.parse(fechaFin);
                } catch (ParseException ex) {
                    throw new IllegalArgumentException("Formato de fecha incorrecto");
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Formato de costo incorrecto");
                }

                // Crear el objeto Conferencia
                Conferencia objConferencia = new Conferencia(nombre, fechaInicioDate, fechaFinDate);

                // Llamar al servicio de almacenamiento para registrar la conferencia
                return objServicioAlmacenamiento.registrarConferencia(objConferencia);
            }

            @Override
            protected void done() {
                try {
                    Conferencia conferenciaRegistrada = get(); // Obtener el resultado del registro
                    if (conferenciaRegistrada != null) {
                        Utilidades.mensajeExito("El registro de la conferencia fue exitoso", "Registro exitoso");
                    } else {
                        Utilidades.mensajeError("El registro de la conferencia no se realizó", "Error en el registro");
                    }
                } catch (IllegalArgumentException e) {
                    Utilidades.mensajeAdvertencia(e.getMessage(), "Error en los datos de entrada");
                } catch (Exception e) {
                    System.err.println("Error al registrar la conferencia: " + e.getMessage());
                    Utilidades.mensajeError("Ocurrió un error al intentar registrar la conferencia", "Error inesperado");
                } finally {
                    jButtonRegistrar.setEnabled(true); // Habilitar el botón nuevamente
                }
            }
        };

        // Ejecutar el SwingWorker para realizar la tarea en segundo plano
        worker.execute();
    }//GEN-LAST:event_jButtonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
