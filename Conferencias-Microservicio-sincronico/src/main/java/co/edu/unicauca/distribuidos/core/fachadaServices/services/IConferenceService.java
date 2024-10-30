
package co.edu.unicauca.distribuidos.core.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.CRUDClientesDTO.ConferenciaDTO;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloDTO;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.ConferenciaConArticulosDTO;

public interface IConferenceService {

	public List<ConferenciaDTO> findAll();

	public ConferenciaDTO findById(Integer id);

	public ConferenciaDTO save(ConferenciaDTO conferencia);

	public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia);

	public boolean delete(Integer id);

	public List<ArticuloDTO> ListarArticulosDeConferencia(Integer idConferencia);

	public ConferenciaConArticulosDTO listarDatosArticuloConSusLibros(Integer idConferencia) ;

	public boolean existeConferencia(Integer codigo);
}
