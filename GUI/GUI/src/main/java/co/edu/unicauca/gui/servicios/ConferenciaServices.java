package co.edu.unicauca.gui.servicios;

import co.edu.unicauca.gui.models.Conferencia;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author sonhuila
 */
public class ConferenciaServices {

    private String endPoint;
    private Client objClientePeticiones;

    public ConferenciaServices() {
        this.endPoint = "http://localhost:5000/api/conferencias";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    // Consultar una conferencia específica
    public Conferencia consultarConferencia(Integer id) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/consultarConferencia/" + id);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.get(Conferencia.class);
    }

    // Listar todas las conferencias
    public List<Conferencia> listarConferencias() {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/listarConferencias");
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        return objPeticion.get(new GenericType<List<Conferencia>>() {
        });
    }

    // Registrar una nueva conferencia
    public Conferencia registrarConferencia(Conferencia objConferenciaRegistrar) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/crearConferencia");
        Entity<Conferencia> data = Entity.entity(objConferenciaRegistrar, MediaType.APPLICATION_JSON_TYPE);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.post(data, Conferencia.class);
    }

    // Actualizar una conferencia existente
    public Conferencia actualizarConferencia(Conferencia objConferenciaActualizar, Integer id) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/actualizarConferencia/" + id);
        Entity<Conferencia> data = Entity.entity(objConferenciaActualizar, MediaType.APPLICATION_JSON_TYPE);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.put(data, Conferencia.class);  // Cambiado a PUT
    }

    // Eliminar una conferencia
    public Boolean eliminarConferencia(Integer id) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/eliminarConferencia/" + id);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.delete(Boolean.class);
    }

    public Boolean consultarSiExisteConferencia(Integer id) {
        Boolean bandera;
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/existe/" + id);
        bandera = target.request(MediaType.APPLICATION_JSON_TYPE).get(Boolean.class);
        return bandera;
    }
}
