package co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.DTO.ArticuloDTO;


public interface IArticuloService {
    public List<ArticuloDTO>ListarArticulos();

	public ArticuloDTO ConsultarArticulo(Integer Codigo);

	public ArticuloDTO AdicionarArticulo(ArticuloDTO Libro);

	public ArticuloDTO ActualizarArticulo(Integer codigo, ArticuloDTO Libro);

	public boolean eliminarArticulo(Integer Codigo);

	public List<ArticuloDTO> ListarArticulosDeConferencia(Integer idCliente);

	public boolean existeArticulo(Integer codigo);
}
