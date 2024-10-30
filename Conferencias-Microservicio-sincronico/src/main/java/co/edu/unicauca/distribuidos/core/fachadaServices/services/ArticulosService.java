package co.edu.unicauca.distribuidos.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import co.edu.unicauca.distribuidos.core.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloDTO;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class ArticulosService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<ArticuloDTO> obtenerArticulosDeConferencia(Integer idCliente) {
        String url = "http://localhost:1000/api/Articulos/ArticuloDeUnaConferencia/" + idCliente;

        Mono<ArticuloDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ArticuloDTO[].class);

        ArticuloDTO[] articulosArray = response.block();
        return articulosArray != null ? List.of(articulosArray) : List.of();
    }

}

