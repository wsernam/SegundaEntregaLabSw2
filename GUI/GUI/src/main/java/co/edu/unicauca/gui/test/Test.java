package co.edu.unicauca.gui.test;

import co.edu.unicauca.gui.servicios.ArticuloServices;
import co.edu.unicauca.gui.servicios.ConferenciaServices;
import co.edu.unicauca.gui.vistas.adminConferencia.VtnPrincipalAdmin;
import javax.swing.UIManager;

/**
 * Clase de prueba para ejecutar la aplicación de gestión de artículos,
 * conferencias y revisores. Esta clase inicializa los repositorios, servicios y
 * vistas de la aplicación, además de simular el flujo de trabajo entre los
 * diferentes componentes.
 *
 * @author
 */
public class Test {

    /**
     * Método principal que inicia la aplicación. Configura el aspecto visual y
     * crea instancias de los repositorios, servicios y vistas necesarias.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        seleccionarLookAndField();

        ArticuloServices objArticuloServices = new ArticuloServices();
        ConferenciaServices objConferenciaServices = new ConferenciaServices();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VtnPrincipalAdmin gui = new VtnPrincipalAdmin(objConferenciaServices, objArticuloServices);
                gui.setVisible(true);
            }
        });
    }

    /**
     * Selecciona el Look and Feel de la interfaz de usuario. Configura el
     * aspecto visual de la aplicación según las preferencias del usuario.
     */
    private static void seleccionarLookAndField() {
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
            } catch (Exception ex) {
            }
        }
    }
}
