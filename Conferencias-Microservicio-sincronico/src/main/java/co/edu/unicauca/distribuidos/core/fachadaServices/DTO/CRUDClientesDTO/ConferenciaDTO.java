package co.edu.unicauca.distribuidos.core.fachadaServices.DTO.CRUDClientesDTO;

import java.util.List;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaDTO {
	private Integer id;
	private String nombre;
	private List<ArticuloDTO> listaArticulos;
	public ConferenciaDTO() {

	}
}