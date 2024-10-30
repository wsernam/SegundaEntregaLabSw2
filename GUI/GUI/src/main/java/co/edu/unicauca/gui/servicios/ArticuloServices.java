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

/**
 *
 * @author sonhuila
 */
public class ArticuloServices {
    private String endPoint;
    private Client objClientePeticiones;
    
    public ArticuloServices()
    {
        this.endPoint = "http://localhost:1000/api/Articulos";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Articulo consultarArticulo(Integer id)
    {
        Articulo objArticulo = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objArticulo = objPeticion.get(Articulo.class);
        
        return objArticulo;
    }
    
    public List<Articulo> listarArticulos()
    {
        List<Articulo> listaArticulos = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        listaArticulos = objPeticion.get(new GenericType<List<Articulo>>() {});
        
        return listaArticulos;
    }
    
    public Articulo registrarArticulo(Articulo objArticuloRegistrar)
    {
        Articulo objArticulo = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<Articulo> data = Entity.entity(objArticuloRegistrar, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objArticulo = objPeticion.post(data, Articulo.class);
        
        return objArticulo;     
    }
    
    public Articulo actualizarArticulo(Articulo objArticuloActualizar, Integer id)
    {
        Articulo objArticulo = null;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);
        Entity<Articulo> data = Entity.entity(objArticuloActualizar, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objArticulo = objPeticion.post(data, Articulo.class);
        
        return objArticulo;
    }
    
    public Boolean eliminarArticulo(Integer id)
    {
        Boolean bandera = false;
        WebTarget target = this.objClientePeticiones.target(this.endPoint+"/"+id);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        bandera = objPeticion.delete(Boolean.class);
        
        return bandera; 
    }
}
