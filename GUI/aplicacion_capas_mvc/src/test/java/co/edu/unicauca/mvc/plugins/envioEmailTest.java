package co.edu.unicauca.mvc.plugins;

import org.junit.jupiter.api.Test;
import java.util.Properties;
import org.junit.jupiter.api.BeforeEach;

/**
 * Clase de prueba para el envío de correos electrónicos utilizando la clase EmailPlugin.
 * Esta clase contiene un método de configuración y un método de prueba para enviar un correo electrónico.
 * 
 * @author thali
 */
public class envioEmailTest {

    private EmailPlugin emailPlugin; // Instancia de EmailPlugin para enviar correos

    /**
     * Método que se ejecuta antes de cada prueba.
     * Configura los parámetros necesarios para el envío de correos electrónicos.
     */
    @BeforeEach
    void setUp() {
        String username = "conferenciasunicauca@hotmail.com"; // Cuenta de Hotmail utilizada para el envío
        String password = "proyecto.software"; // Contraseña de la cuenta de Hotmail

        // Configuración de propiedades para el servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp-mail.outlook.com"); // Servidor SMTP de Outlook
        properties.put("mail.smtp.port", "587"); // Puerto SMTP para conexiones TLS
        properties.put("mail.smtp.auth", "true"); // Habilita la autenticación
        properties.put("mail.smtp.starttls.enable", "true"); // Habilita TLS para la conexión

        // Inicializa el objeto emailPlugin con los parámetros configurados
        emailPlugin = new EmailPlugin(username, password, properties);
    }

    /**
     * Método de prueba que envía un correo electrónico.
     * Este método verifica que se pueda enviar un correo correctamente.
     */
    @Test
    void testSendEmail() {
        String to = "thaliaepe@hotmail.com"; // Dirección de correo de destino
        String subject = "CONFIRMACION Y NOTIFICACION RECEPCION TRABAJO"; // Asunto del correo
        String body = "El trabajo ha sido recibido de manera exitosa"; // Cuerpo del correo
        
        // Envía el correo real utilizando el plugin de correo
        emailPlugin.sendEmail(to, subject, body);
        
        // Imprime un mensaje de éxito en la consola
        System.out.println("Correo enviado correctamente a " + to);
    }
}
