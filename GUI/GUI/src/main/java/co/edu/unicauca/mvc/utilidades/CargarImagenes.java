package co.edu.unicauca.mvc.utilidades;

import javax.swing.ImageIcon;

/**
 * Clase utilitaria para cargar imágenes desde una ruta especificada.
 * 
 * Esta clase proporciona un método para cargar imágenes como objetos
 * {@link ImageIcon} desde la ubicación del recurso especificada.
 * 
 * @author LENOVO
 */
public class CargarImagenes {
    
    /**
     * Carga una imagen desde la ruta especificada.
     * 
     * @param ruta La ruta del recurso de la imagen a cargar.
     * @return Un objeto {@link ImageIcon} que representa la imagen cargada.
     */
    public ImageIcon CargarImagen(String ruta) {
        ImageIcon imagen = new javax.swing.ImageIcon(getClass().getResource(ruta));  
        return imagen;
    }
}
