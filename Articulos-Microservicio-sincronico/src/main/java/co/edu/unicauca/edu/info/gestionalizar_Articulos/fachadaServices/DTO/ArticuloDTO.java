package co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.DTO;

import java.util.List;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.models.ConferenciaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ArticuloDTO {
	private int idArticulo;
    private String nombre;
    private String autores;
    private String resumen;
	private List<ConferenciaEntity> conferencias;

    public ArticuloDTO(){
        
    }
}
