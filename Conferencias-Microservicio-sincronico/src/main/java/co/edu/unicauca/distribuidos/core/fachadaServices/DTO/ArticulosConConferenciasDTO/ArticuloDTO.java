package co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ArticuloDTO {
    private int idArticulo;
    private String nombre;
    private String resumen;

    public ArticuloDTO(){
        
    }
}
