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
    
    public ConferenciaServices()
    {
        this.endPoint = "http://localhost:5000/api/conferencias";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Conferencia consultarConferencia(Integer id)
    {
        Conferencia objConferencia = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objConferencia = objPeticion.get(Conferencia.class);
        
        return objConferencia;
    }
    
    public List<Conferencia> listarConferencias()
    {
        List<Conferencia> listaConferencias = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        listaConferencias = objPeticion.get(new GenericType<List<Conferencia>>() {});
        
        return listaConferencias;
    }
    
    public Conferencia registrarConferencia(Conferencia objConferenciaRegistrar)
    {
        Conferencia objConferencia = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<Conferencia> data = Entity.entity(objConferenciaRegistrar, MediaType.APPLICATION_JSON_TYPE);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objConferencia = objPeticion.post(data, Conferencia.class);
        
        return objConferencia;     
    }
    
    public Conferencia actualizarConferencia(Conferencia objConferenciaActualizar, Integer id)
    {
        Conferencia objConferencia = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);
        Entity<Conferencia> data = Entity.entity(objConferenciaActualizar, MediaType.APPLICATION_JSON_TYPE);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objConferencia = objPeticion.post(data, Conferencia.class);
        
        return objConferencia;
    }
    
    public Boolean eliminarConferencia(Integer id)
    {
        Boolean bandera = false;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        bandera = objPeticion.delete(Boolean.class);
        
        return bandera; 
    }
}
