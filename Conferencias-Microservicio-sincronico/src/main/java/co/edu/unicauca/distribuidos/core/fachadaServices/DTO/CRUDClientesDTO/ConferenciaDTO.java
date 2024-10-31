package co.edu.unicauca.distribuidos.core.fachadaServices.DTO.CRUDClientesDTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaDTO {
	private Integer id;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	public ConferenciaDTO() {

	}
}