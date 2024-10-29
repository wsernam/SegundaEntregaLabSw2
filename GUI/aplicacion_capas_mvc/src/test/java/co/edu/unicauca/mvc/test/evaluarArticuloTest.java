package co.edu.unicauca.mvc.test;

import co.edu.unicauca.mvc.controladores.ServicioAlmacenamientoArticulos;
import co.edu.unicauca.mvc.modelos.Articulo;
import co.edu.unicauca.mvc.modelos.ArticuloReview;
import co.edu.unicauca.mvc.accesoADatos.InterfaceRepositorioArticulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de prueba para evaluar artículos en el servicio de almacenamiento.
 * Esta clase contiene pruebas para agregar revisiones a los artículos y verificar su correcta implementación.
 * 
 * @author sonhuila
 */
class evaluarArticuloTest {

    private ServicioAlmacenamientoArticulos servicio; // Servicio para manejar artículos
    private InterfaceRepositorioArticulo repositorioMock; // Repositorio simulado para pruebas

    /**
     * Método que se ejecuta antes de cada prueba.
     * Inicializa el repositorio simulado y almacena un artículo de prueba.
     */
    @BeforeEach
    void setUp() {
        // Inicializar el repositorio simulado
        repositorioMock = new InterfaceRepositorioArticulo() {
            private List<Articulo> articulos = new ArrayList<>(); // Lista de artículos almacenados

            @Override
            public boolean almacenarArticulo(Articulo objArticulo) {
                return articulos.add(objArticulo); // Almacena el artículo en la lista
            }

            @Override
            public List<Articulo> listarArticulos() {
                return articulos; // Devuelve la lista de artículos
            }

            @Override
            public boolean eliminarArticulo(int idArticulo) {
                return articulos.removeIf(a -> a.getIdArticulo() == idArticulo); // Elimina el artículo por ID
            }

            @Override
            public Articulo consultarArticulo(int idArticulo) {
                return articulos.stream()
                        .filter(a -> a.getIdArticulo() == idArticulo)
                        .findFirst()
                        .orElse(null); // Consulta el artículo por ID
            }

            @Override
            public boolean actualizarArticulo(Articulo objArticulo) {
                for (int i = 0; i < articulos.size(); i++) {
                    if (articulos.get(i).getIdArticulo() == objArticulo.getIdArticulo()) {
                        articulos.set(i, objArticulo); // Actualiza el artículo existente
                        return true;
                    }
                }
                return false; // Retorna false si no se encuentra el artículo
            }
        };

        // Inicializa el servicio de almacenamiento de artículos con el repositorio simulado
        servicio = new ServicioAlmacenamientoArticulos(repositorioMock);
        
        // Crear un artículo para las pruebas
        Articulo articuloPrueba = new Articulo("Título Prueba", "Autores Prueba");
        articuloPrueba.setIdArticulo(1); // Asignar un ID
        servicio.almacenarArticulo(articuloPrueba); // Almacenar el artículo de prueba
    }

    /**
     * Prueba para evaluar un artículo agregando una revisión.
     * Verifica que la revisión se haya agregado correctamente al artículo.
     */
    @Test
    void testEvaluarArticulo() {
        // Obtener el artículo para evaluar
        Articulo articulo = servicio.listarArticulos().get(0); // Recuperar el primer artículo almacenado

        // Crear una revisión
        ArticuloReview revision = new ArticuloReview("Comentario de prueba", 4.5);
        
        // Evaluar el artículo
        servicio.agregarRevisionArticulo(articulo, revision); // Usar el método de servicio para agregar revisión

        // Verificar que la revisión se haya agregado correctamente
        List<ArticuloReview> revisiones = servicio.obtenerRevisionesArticulo(articulo);
        assertNotNull(revisiones, "La lista de revisiones no debería ser nula.");
        assertEquals(1, revisiones.size(), "Debería haber 1 revisión almacenada.");
        assertEquals("Comentario de prueba", revisiones.get(0).getComentarios(), "El comentario de la revisión debería coincidir.");
        assertEquals(4.5, revisiones.get(0).getCalificacion(), "La calificación de la revisión debería ser 4.5.");
    }
}
