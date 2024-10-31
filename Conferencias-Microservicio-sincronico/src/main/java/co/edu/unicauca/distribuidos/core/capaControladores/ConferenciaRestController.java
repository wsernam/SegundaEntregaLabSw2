
package co.edu.unicauca.distribuidos.core.capaControladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.ConferenciaConArticulosDTO;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.CRUDClientesDTO.ConferenciaDTO;
import co.edu.unicauca.distribuidos.core.fachadaServices.services.IConferenceService;
@RestController
@RequestMapping("/api/conferencias")
@CrossOrigin(origins = "http://localhost:4200",  
 methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}) 
public class ConferenciaRestController {

	@Autowired
	private IConferenceService ConferenciaService;

	@GetMapping("/listarConferencias") 
	public List<ConferenciaDTO> listarConferencias() {
		return ConferenciaService.findAll();
	}

	@GetMapping("/ContarArticulosConSusConferencias/{idConferencia}") 
	public int ContarArticulosConSusConferencias(@PathVariable("idConferencia")  Integer idConferencia) {
		return ConferenciaService.ListarArticulosDeConferencia(idConferencia).size();
	}
	
	@GetMapping("/ListarArticulosDeConferencia/{idConferencia}") 
	public List<co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloDTO> listarArticulosConSusConferencias(@PathVariable("idConferencia")  Integer idConferencia) {
		return ConferenciaService.ListarArticulosDeConferencia(idConferencia);
	}

	@GetMapping("/listarDatosConferenciaConSusArticulos/{idConferencia}") 
	public ConferenciaConArticulosDTO listarDatosConferenciaConSusArticulos(@PathVariable("idConferencia")  Integer idConferencia) {
		return ConferenciaService.listarDatosArticuloConSusConferencias(idConferencia);
	}

	@GetMapping("/existe/{codigo}")
    public ResponseEntity<Boolean> existeConferencia(@PathVariable Integer codigo) {
        boolean existe = ConferenciaService.existeConferencia(codigo);
        return ResponseEntity.ok(existe);
    }

	@GetMapping("/consultarConferencia/{idConferencia}")
	public ConferenciaDTO consultarConferencia(@PathVariable("idConferencia") Integer id) {
		ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.findById(id);
		return objConferencia;
	}

	@GetMapping("Anosviejos/{name}/{age}")
	public String getMessage(@PathVariable String name,
			@PathVariable("age") String edad) {
		String msg = "%s es %s años viejo".formatted(name, edad);
		System.out.println(msg);
		return msg;
	}

	@GetMapping("consultarClientes")
	public String consultarClientesConVariosParametros(@RequestParam String nombres,
			@RequestParam String apellidos) {
		String msg = "buscando un cliente por nombre: %s, apellidos: %s".formatted(nombres, apellidos);
		System.out.println(msg);
		return msg;
	}

	@PostMapping("/crearConferencia")
	public ConferenciaDTO crearConferencia(@RequestBody ConferenciaDTO cliente) {
		ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.save(cliente);
		return objConferencia;
	}

	@PutMapping("/actualizarConferencia/{idConferencia}")
	public ConferenciaDTO actualizarConferencia(@RequestBody ConferenciaDTO cliente, @PathVariable("idConferencia") Integer idConferencia) {
		ConferenciaDTO objConferencia = null;
		ConferenciaDTO ConferenciaActual = ConferenciaService.findById(idConferencia);
		if (ConferenciaActual != null) {
			objConferencia = ConferenciaService.update(idConferencia, cliente);
		}
		return objConferencia;
	}

	@DeleteMapping("/eliminarConferencia/{idConferencia}")
	public Boolean eliminarConferencia(@PathVariable("idConferencia") Integer idConferencia) {
		Boolean bandera = false;
		ConferenciaDTO ConferenciaActual = ConferenciaService.findById(idConferencia);
		if (ConferenciaActual != null) {
			bandera = ConferenciaService.delete(idConferencia);
		}
		return bandera;
	}

	@GetMapping("/clientes/listarCabeceras")
	public void listarCabeceras(@RequestHeader Map<String, String> headers) {
		System.out.println("cabeceras");
		headers.forEach((key, value) -> {
			System.out.println("Cabecera '%s' = %s".formatted(key, value));
		});
	}

}
