package co.edu.unicauca.gui.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sonhuila
 */

/**
 * Clase que representa una conferencia científica.
 * Contiene información sobre el nombre, fechas, costo de inscripción y 
 * listas de artículos enviados y revisores asignados a la conferencia.
 */
public class Conferencia {

    /**
     * ID único para identificar la conferencia.
     */
    @JsonProperty("id")
    private int idConferencia;

    /**
     * Nombre de la conferencia.
     */
    private String nombre;

    /**
     * Fecha de inicio de la conferencia.
     */
    private Date fechaInicio;

    /**
     * Fecha de finalización de la conferencia.
     */
    private Date fechaFin;

    /**
     * Lista de artículos enviados a la conferencia.
     */
    private ArrayList<Articulo> articulosEnviados;

    /**
     * Constructor para crear una conferencia con los datos iniciales.
     * 
     * @param nombre Nombre de la conferencia.
     * @param fechaInicio Fecha de inicio de la conferencia.
     * @param fechaFin Fecha de finalización de la conferencia.
     */
    public Conferencia() {
        // Inicializa la lista de artículos para evitar NullPointerException
        this.articulosEnviados = new ArrayList<>();
    }
    public Conferencia(String nombre, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.articulosEnviados = new ArrayList<>();
    }

    /**
     * Obtiene el ID único de la conferencia.
     * 
     * @return El ID de la conferencia.
     */
    public int getIdConferencia() {
        return idConferencia;
    }

    /**
     * Establece el ID único de la conferencia.
     * 
     * @param idConferencia El ID a asignar a la conferencia.
     */
    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    /**
     * Obtiene el nombre de la conferencia.
     * 
     * @return El nombre de la conferencia.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la conferencia.
     * 
     * @param nombre El nombre a asignar a la conferencia.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de inicio de la conferencia.
     * 
     * @return La fecha de inicio de la conferencia.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio de la conferencia.
     * 
     * @param fechaInicio La fecha de inicio a asignar.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de finalización de la conferencia.
     * 
     * @return La fecha de finalización de la conferencia.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de finalización de la conferencia.
     * 
     * @param fechaFin La fecha de finalización a asignar.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene la lista de artículos enviados a la conferencia.
     * 
     * @return Una lista de artículos enviados.
     */
    public ArrayList<Articulo> getArticulosEnviados() {
        return articulosEnviados;
    }

    /**
     * Establece la lista de artículos enviados a la conferencia.
     * 
     * @param articulosEnviados La lista de artículos a asignar.
     */
    public void setArticulosEnviados(ArrayList<Articulo> articulosEnviados) {
        this.articulosEnviados = articulosEnviados;
    }

    /**
     * Agrega un artículo a la lista de artículos enviados a la conferencia.
     * 
     * @param articulo El artículo a agregar.
     * @return true si el artículo fue agregado con éxito, false de lo contrario.
     */
    public boolean agregarArticuloAConferencia(Articulo articulo) {
        return articulosEnviados.add(articulo);
    }


    /**
     * Retorna una representación en cadena de la conferencia (su nombre).
     * 
     * @return El nombre de la conferencia.
     */
    @Override
    public String toString() {
        return this.nombre;
    }
}
