package co.edu.unicauca.distribuidos.core.capaAccesoADatos.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaEntity {
	private Integer id;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	public ConferenciaEntity(){
		
	}
}
