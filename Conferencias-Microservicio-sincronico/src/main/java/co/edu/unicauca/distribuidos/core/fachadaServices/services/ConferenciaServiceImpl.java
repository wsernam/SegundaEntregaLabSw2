
package co.edu.unicauca.distribuidos.core.fachadaServices.services;

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

		List<ConferenciaEntity> clientesEntity = this.servicioAccesoBaseDatos.findAll();
		List<ConferenciaDTO> clientesDTO = this.modelMapper.map(clientesEntity, new TypeToken<List<ConferenciaDTO>>() {
		}.getType());
		return clientesDTO;
	}

	@Override
	public ConferenciaDTO findById(Integer id) {
		ConferenciaEntity objCLienteEntity = this.servicioAccesoBaseDatos.findById(id);
		ConferenciaDTO conferenciaDTO = this.modelMapper.map(objCLienteEntity, ConferenciaDTO.class);
		return conferenciaDTO;
	}

	@Override
	public ConferenciaDTO save(ConferenciaDTO cliente) {
		ConferenciaEntity clienteEntity = this.modelMapper.map(cliente, ConferenciaEntity.class);
		ConferenciaEntity objCLienteEntity = this.servicioAccesoBaseDatos.save(clienteEntity);
		ConferenciaDTO ConferenciaDTO = this.modelMapper.map(objCLienteEntity, ConferenciaDTO.class);
		ConferenciaCreadaEvent evento = new ConferenciaCreadaEvent(objCLienteEntity.getId(), objCLienteEntity.getNombre(), objCLienteEntity.getFechaInicio(), objCLienteEntity.getFechaFin());
		rabbitTemplate.convertAndSend("conferencia-exchange", "conferencia.creada", evento);
		return ConferenciaDTO;
	}

	@Override
	public ConferenciaDTO update(Integer id, ConferenciaDTO cliente) {
		ConferenciaEntity conferenciaEntity = this.modelMapper.map(cliente, ConferenciaEntity.class);
		conferenciaEntity.setId(id);  // Asegura que el ID es correcto
		ConferenciaEntity conferenciaEntityActualizado = this.servicioAccesoBaseDatos.update(id, conferenciaEntity);
		ConferenciaDTO clienteDTO = this.modelMapper.map(conferenciaEntityActualizado, ConferenciaDTO.class);
		return clienteDTO;
	}

	@Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);
	}

	@Override
	public List<ArticuloDTO> ListarArticulosDeConferencia(Integer idCliente) {
		//invocación sincrona de servicio web que permite obtener los articulos de de la conferencia	
		List<ArticuloDTO> listaArticulosConferencia;
		listaArticulosConferencia=this.servicioConsumirObtencionArticulos.obtenerLibrosDeCliente(idCliente);
		return listaArticulosConferencia;
	}

	@Override
	public ConferenciaConArticulosDTO listarDatosArticuloConSusLibros(Integer idCliente) {
		List<ArticuloDTO> listaArticulosConferencia;
		listaArticulosConferencia=this.servicioConsumirObtencionArticulos.obtenerLibrosDeCliente(idCliente);
		ConferenciaEntity objCLienteEntity = this.servicioAccesoBaseDatos.findById(idCliente);
		ConferenciaDTO objClienteDTO = this.modelMapper.map(objCLienteEntity, ConferenciaDTO.class);		
		ConferenciaConArticulosDTO objCliente= new ConferenciaConArticulosDTO(objClienteDTO, listaArticulosConferencia);
		return objCliente;
	}
}
