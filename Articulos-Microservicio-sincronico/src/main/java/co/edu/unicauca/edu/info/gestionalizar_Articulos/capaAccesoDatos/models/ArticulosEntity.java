package co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ArticulosEntity {
	private int idArticulo;
    private String nombre;
    private String resumen;
	private List<ConferenciaEntity> conferencias;

    public ArticulosEntity(){
    
    }
}

