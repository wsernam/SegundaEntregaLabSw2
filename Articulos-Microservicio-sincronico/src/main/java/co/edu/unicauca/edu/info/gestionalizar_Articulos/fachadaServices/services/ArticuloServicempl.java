package co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.models.ArticulosEntity;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.repositories.ArticuloRepository;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.DTO.ArticuloDTO;

@Service
public class ArticuloServicempl implements IArticuloService {
    @Autowired
	private ArticuloRepository servicioAccesoBaseDatos;

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

    @Override
    public ArticuloDTO AdicionarArticulo(ArticuloDTO Libro) {
        // Implementación para agregar un nuevo libro
        ArticulosEntity libroEntity = modelMapper.map(Libro, ArticulosEntity.class);
        ArticulosEntity nuevoLibro = servicioAccesoBaseDatos.AdicionarArticulo(libroEntity);
        return modelMapper.map(nuevoLibro, ArticuloDTO.class);
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
