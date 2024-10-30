package co.edu.unicauca.gui.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author sonhuila
 */
public class Articulo {
    private static int idCounter = 1;
    private int idArticulo;
    
    @JsonProperty("nombre")
    private String titulo;
    private String autores;
    private String resumen;
    
    @JsonProperty("conferencias")
    private List<Conferencia> conferencias;  // Cambiar a lista para coincidir con el JSON

    public Articulo() {
    }

    public Articulo(String titulo, String autores, String resumen) {
        this.idArticulo = idCounter++;
        this.titulo = titulo;
        this.autores = autores;
        this.resumen = resumen;
    }

    // Getters y Setters
    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo o vacío.");
        }
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        if (autores == null || autores.trim().isEmpty()) {
            throw new IllegalArgumentException("Los autores no pueden ser nulos o vacíos.");
        }
        this.autores = autores;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        if (resumen == null || resumen.trim().isEmpty()) {
            throw new IllegalArgumentException("El resumen no puede ser nulo o vacío.");
        }
        this.resumen = resumen;
    }

    public List<Conferencia> getConferencias() {
        return conferencias;
    }

    public void setConferencias(List<Conferencia> conferencias) {
        this.conferencias = conferencias;
    }
}

