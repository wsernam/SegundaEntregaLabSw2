package co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.events;

import java.io.Serializable;
import java.util.List;

import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.models.ConferenciaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ArticuloCreadoEvent implements Serializable{
    
    private Integer idArticulo;
    private String nombre;
    private String resumen;
    private List<ConferenciaEntity> conferencias;
    
    public ArticuloCreadoEvent(){
    }
}
