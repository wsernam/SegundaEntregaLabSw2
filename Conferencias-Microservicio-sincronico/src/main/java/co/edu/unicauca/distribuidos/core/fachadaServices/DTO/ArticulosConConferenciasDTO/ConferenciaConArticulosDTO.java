package co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO;

import java.util.List;

import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.CRUDClientesDTO.ConferenciaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaConArticulosDTO {
    private ConferenciaDTO objConferencia;
    private List<ArticuloDTO> listaArticulos;
}
