package co.edu.unicauca.edu.info.gestionalizar_Articulos.capaControladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.DTO.ArticuloDTO;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.fachadaServices.services.IArticuloService;

@RestController
@RequestMapping("/api/Articulos")
public class ArticuloRestController {

    @Autowired

    private IArticuloService articuloService;

    @GetMapping("/listarArticulos")
    public List<ArticuloDTO> listarArticulos() {
        return articuloService.ListarArticulos();
    }
    @GetMapping("ArticuloDeUnaConferencia/{idConferencia}")
    public List<ArticuloDTO> listandoArticulosDeUnaConferencia(@PathVariable("idConferencia")  Integer idConferencia) {
        System.out.println("Consumiendo servicios para obtener articulo de la conferencia con id "+idConferencia);
        return articuloService.ListarArticulosDeConferencia(idConferencia);
    }

    @GetMapping("/consultarArticulo/{idArticulo}")
    public ResponseEntity<ArticuloDTO> consultarArticulo(@PathVariable("idArticulo") Integer codigo) {
        ArticuloDTO libro = articuloService.ConsultarArticulo(codigo);
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

        // Consultar si existe un artículo
    @GetMapping("/existe/{codigo}")
    public ResponseEntity<Boolean> existeArticulo(@PathVariable Integer codigo) {
        boolean existe = articuloService.existeArticulo(codigo);
        return ResponseEntity.ok(existe);
    }

    @PostMapping("/adicionarArticulo/Crear")
    public ResponseEntity<ArticuloDTO> adicionarArticulo(@RequestBody ArticuloDTO libro) {
        ArticuloDTO nuevoLibro = articuloService.AdicionarArticulo(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @PutMapping("/ActualizarArticulo/{idArticulo}")
    public ResponseEntity<ArticuloDTO> actualizarArticulo(@PathVariable("idArticulo") Integer idArticulo, @RequestBody ArticuloDTO libro) {
        ArticuloDTO ArticuloActual = articuloService.ConsultarArticulo(idArticulo);
        if (ArticuloActual != null) {
            ArticuloDTO libroActualizado = articuloService.ActualizarArticulo(idArticulo, libro);
            return ResponseEntity.ok(libroActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminarArticulo/{idArticulo}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable("idArticulo") Integer idArticulo) {
        ArticuloDTO articuloActual = articuloService.ConsultarArticulo(idArticulo);
        if (articuloActual != null) {
            articuloService.eliminarArticulo(idArticulo);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   
}
