package co.edu.unicauca.gui.servicios;

import co.edu.unicauca.gui.models.Articulo;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

public class ArticuloServices {
    private String endPoint;
    private Client objClientePeticiones;

    public ArticuloServices() {
        this.endPoint = "http://localhost:1000/api/Articulos";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Articulo consultarArticulo(Integer id) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/consultarArticulo/" + id);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.get(Articulo.class);
    }

    public List<Articulo> listarArticulos() {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/listarArticulos");
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        return objPeticion.get(new GenericType<List<Articulo>>() {});
    }

    public Articulo registrarArticulo(Articulo objArticuloRegistrar) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/adicionarArticulo/Crear");
        Entity<Articulo> data = Entity.entity(objArticuloRegistrar, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.post(data, Articulo.class);
    }

    public Articulo actualizarArticulo(Articulo objArticuloActualizar, Integer id) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/ActualizarArticulo/" + id);
        Entity<Articulo> data = Entity.entity(objArticuloActualizar, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.put(data, Articulo.class);  // Cambiado a PUT
    }

    public Boolean eliminarArticulo(Integer id) {
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/eliminarArticulo/" + id);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        return objPeticion.delete(Boolean.class);
    }
    
    public Boolean consultarSiExisteArticulo(Integer id) {
        Boolean bandera;
        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/existe/" + id);
        bandera = target.request(MediaType.APPLICATION_JSON_TYPE).get(Boolean.class);
        return bandera;
    }
}
