package co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.qos.logback.classic.Logger;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.models.ArticulosEntity;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.repositories.ArticuloRepository;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.DTO.ArticuloDTO;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.events.ArticuloCreadoEvent;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.rabbit.ConfigRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@Service
public class ArticuloServicempl implements IArticuloService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ArticuloServicempl.class);
    @Autowired
	private ArticuloRepository servicioAccesoBaseDatos;
    private final RabbitTemplate rabbitTemplate;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ArticuloDTO> ListarArticulos() {
		List<ArticulosEntity> LibroEntity = this.servicioAccesoBaseDatos.ListarArticulos();
		List<ArticuloDTO> LibroDTO = this.modelMapper.map(LibroEntity, new TypeToken<List<ArticuloDTO>>() {
		}.getType());
		return LibroDTO;
	}
   
    @Override
    public boolean eliminarArticulo(Integer codigo) {
        // Implementación para eliminar un libro
        return servicioAccesoBaseDatos.EliminarArticulo(codigo);
    }

    public void enviarEventoArticuloCreado(ArticuloCreadoEvent evento) {
        try {
            rabbitTemplate.convertAndSend(ConfigRabbitMQ.ARTICULO_EXCHANGE, ConfigRabbitMQ.ARTICULO_ROUTING_KEY, evento);
            logger.info("Evento ArticuloCreadoEvent enviado exitosamente: {}", evento);
        } catch (Exception e) {
            logger.error("Error al enviar el evento ArticuloCreadoEvent: {}", evento, e);
        }
    }

    @Override
    public ArticuloDTO AdicionarArticulo(ArticuloDTO Libro) {
        // Implementación para agregar un nuevo libro
        ArticulosEntity libroEntity = modelMapper.map(Libro, ArticulosEntity.class);
        ArticulosEntity nuevoArticulo = servicioAccesoBaseDatos.AdicionarArticulo(libroEntity);
        ArticuloCreadoEvent evento = new ArticuloCreadoEvent(nuevoArticulo.getIdArticulo(), nuevoArticulo.getNombre(), nuevoArticulo.getResumen(), nuevoArticulo.getConferencias());
        enviarEventoArticuloCreado(evento);
        return modelMapper.map(nuevoArticulo, ArticuloDTO.class);
    }

    @Override
    public ArticuloDTO ActualizarArticulo(Integer codigo, ArticuloDTO articulo) {
        // Mapea el DTO a la entidad, pero asigna el ID manualmente
        ArticulosEntity articuloEntity = modelMapper.map(articulo, ArticulosEntity.class);
        articuloEntity.setIdArticulo(codigo);  // Asegura que el ID es correcto
    
        // Actualiza el artículo en la base de datos
        ArticulosEntity articuloActualizado = servicioAccesoBaseDatos.ActualizarArticulo(codigo, articuloEntity);
        // Mapea de vuelta a DTO
        return modelMapper.map(articuloActualizado, ArticuloDTO.class);
    }

    @Override
    public ArticuloDTO ConsultarArticulo(Integer Codigo) {
        // Implementación para consultar un libro
        ArticulosEntity libroEntity = servicioAccesoBaseDatos.ConsultarArticulo(Codigo);
        return modelMapper.map(libroEntity, ArticuloDTO.class);
    }



    @Override
    public List<ArticuloDTO> ListarArticulosDeCliente(Integer idCliente) {
        List<ArticulosEntity> listaArticulos = this.servicioAccesoBaseDatos.ListarArticulosDeCliente(idCliente);
		List<ArticuloDTO> listaArticulosDTO = this.modelMapper.map(listaArticulos, new TypeToken<List<ArticuloDTO>>() {
		}.getType());
		return listaArticulosDTO;
    }



}
