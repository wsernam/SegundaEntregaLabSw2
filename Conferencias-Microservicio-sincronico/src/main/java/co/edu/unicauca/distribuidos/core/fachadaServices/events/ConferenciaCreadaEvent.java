package co.edu.unicauca.distribuidos.core.fachadaServices.events;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaCreadaEvent implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private Date fechaInicio;
	private Date fechaFin;
    ConferenciaCreadaEvent(){
        
    }
}
