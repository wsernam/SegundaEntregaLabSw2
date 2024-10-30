
package co.edu.unicauca.distribuidos.core.fachadaServices.services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.distribuidos.core.capaAccesoADatos.models.ConferenciaEntity;
import co.edu.unicauca.distribuidos.core.capaAccesoADatos.repositories.ConfereciaRepository;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.*;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloDTO;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.CRUDClientesDTO.*;
import co.edu.unicauca.distribuidos.core.fachadaServices.events.ConferenciaCreadaEvent;

@Service
public class ConferenciaServiceImpl implements IConferenceService {

	@Autowired
    private RabbitTemplate rabbitTemplate;
	private ConfereciaRepository servicioAccesoBaseDatos;
	private ArticulosService servicioConsumirObtencionArticulos;
	private ModelMapper modelMapper;

	public ConferenciaServiceImpl(ConfereciaRepository servicioAccesoBaseDatos, ModelMapper modelMapper,ArticulosService servicioConsumirObtencionLibros) {
		this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
		this.modelMapper = modelMapper;
		this.servicioConsumirObtencionArticulos=servicioConsumirObtencionLibros;
	}

	@Override
	public List<ConferenciaDTO> findAll() {

		List<ConferenciaEntity> conferenciaEntity = this.servicioAccesoBaseDatos.findAll();
		List<ConferenciaDTO> conferenciaDTO = this.modelMapper.map(conferenciaEntity, new TypeToken<List<ConferenciaDTO>>() {
		}.getType());
		return conferenciaDTO;
	}

	@Override
	public ConferenciaDTO findById(Integer id) {
		ConferenciaEntity objCLienteEntity = this.servicioAccesoBaseDatos.findById(id);
		ConferenciaDTO conferenciaDTO = this.modelMapper.map(objCLienteEntity, ConferenciaDTO.class);
		return conferenciaDTO;
	}

	@Override
	public ConferenciaDTO save(ConferenciaDTO conferencia) {
		ConferenciaEntity clienteEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
		ConferenciaEntity objCLienteEntity = this.servicioAccesoBaseDatos.save(clienteEntity);
		ConferenciaDTO ConferenciaDTO = this.modelMapper.map(objCLienteEntity, ConferenciaDTO.class);
		ConferenciaCreadaEvent evento = new ConferenciaCreadaEvent(objCLienteEntity.getId(), objCLienteEntity.getNombre(), objCLienteEntity.getFechaInicio(), objCLienteEntity.getFechaFin());
		rabbitTemplate.convertAndSend("conferencia-exchange", "conferencia.creada", evento);
		return ConferenciaDTO;
	}

	@Override
	public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia) {
		ConferenciaEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
		conferenciaEntity.setId(id);  // Asegura que el ID es correcto
		ConferenciaEntity conferenciaEntityActualizado = this.servicioAccesoBaseDatos.update(id, conferenciaEntity);
		ConferenciaDTO ConferenciaDTO = this.modelMapper.map(conferenciaEntityActualizado, ConferenciaDTO.class);
		return ConferenciaDTO;
	}

	@Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);
	}

	@Override
	public List<ArticuloDTO> ListarArticulosDeConferencia(Integer idConferencia) {
		//invocación sincrona de servicio web que permite obtener los articulos de de la conferencia	
		List<ArticuloDTO> listaArticulosConferencia;
		listaArticulosConferencia=this.servicioConsumirObtencionArticulos.obtenerArticulosDeConferencia(idConferencia);
		return listaArticulosConferencia;
	}

	@Override
	public List<ConferenciaConArticulosDTO> listarConferencias() {
		// Obtiene todas las conferencias desde la base de datos
		List<ConferenciaEntity> listaConferenciasEntity = this.servicioAccesoBaseDatos.findAll();
		List<ConferenciaConArticulosDTO> listaConferenciasConArticulos = new ArrayList<>();

		// Itera sobre cada conferencia y mapea sus datos y artículos
		for (ConferenciaEntity conferenciaEntity : listaConferenciasEntity) {
			// Mapea ConferenciaEntity a ConferenciaDTO
			ConferenciaDTO conferenciaDTO = this.modelMapper.map(conferenciaEntity, ConferenciaDTO.class);

			// Obtiene los artículos de la conferencia actual
			List<ArticuloDTO> listaArticulosConferencia = this.servicioConsumirObtencionArticulos.obtenerArticulosDeConferencia(conferenciaEntity.getId());

			// Crea un objeto ConferenciaConArticulosDTO y lo añade a la lista
			ConferenciaConArticulosDTO conferenciaConArticulos = new ConferenciaConArticulosDTO(conferenciaDTO, listaArticulosConferencia);
			listaConferenciasConArticulos.add(conferenciaConArticulos);
		}

		return listaConferenciasConArticulos;
	}


	@Override
	public ConferenciaConArticulosDTO listarDatosArticuloConSusConferencias(Integer idArticulos) {
		List<ArticuloDTO> listaArticulosConferencia;
		listaArticulosConferencia=this.servicioConsumirObtencionArticulos.obtenerArticulosDeConferencia(idArticulos);
		ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.findById(idArticulos);
		ConferenciaDTO objConferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);		
		ConferenciaConArticulosDTO objConferencia= new ConferenciaConArticulosDTO(objConferenciaDTO, listaArticulosConferencia);
		return objConferencia;
	}

	@Override
	public boolean existeConferencia(Integer codigo) {
        ConferenciaEntity conferencia = servicioAccesoBaseDatos.findById(codigo);
        return conferencia != null;
    }
}
