package co.edu.unicauca.mvc.test;

import co.edu.unicauca.mvc.accesoADatos.InterfaceRepositorioArticulo;
import co.edu.unicauca.mvc.controladores.ServicioAlmacenamientoArticulos;
import co.edu.unicauca.mvc.modelos.Articulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la funcionalidad del servicio de almacenamiento de artículos.
 * Esta clase contiene pruebas para almacenar, listar, eliminar, consultar y actualizar artículos.
 * 
 * @author thali
 */
class ServiciosArticuloTest {

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

        // Crear un artículo de prueba y almacenarlo
        Articulo articuloPrueba = new Articulo("Título Prueba", "Autores Prueba");
        articuloPrueba.setIdArticulo(1); // Asignar un ID único al artículo de prueba
        servicio.almacenarArticulo(articuloPrueba); // Almacenar el artículo de prueba
    }

    /**
     * Prueba para almacenar un nuevo artículo.
     * Verifica que el artículo se almacene correctamente en el repositorio.
     */
    @Test
    void testAlmacenarArticulo() {
        // Crear un nuevo artículo
        Articulo nuevoArticulo = new Articulo("Nuevo Artículo", "Nuevos Autores");
        nuevoArticulo.setIdArticulo(2); // Asignar un nuevo ID

        // Llamar al método almacenarArticulo
        boolean resultado = servicio.almacenarArticulo(nuevoArticulo);

        // Verificar si el artículo fue almacenado correctamente
        assertTrue(resultado, "El artículo debería haberse almacenado correctamente.");
        assertEquals(2, servicio.listarArticulos().size(), "Debería haber 2 artículos almacenados.");
    }

    /**
     * Prueba para listar todos los artículos almacenados.
     * Verifica que el artículo de prueba esté en la lista.
     */
    @Test
    void testListarArticulos() {
        // Llamar al método listarArticulos
        List<Articulo> listaArticulos = servicio.listarArticulos();

        // Verificar si la lista contiene el artículo de prueba
        assertEquals(1, listaArticulos.size(), "Debería haber 1 artículo almacenado.");
        assertEquals("Título Prueba", listaArticulos.get(0).getTitulo(), "El título del artículo debería coincidir.");
    }

    /**
     * Prueba para eliminar un artículo por su ID.
     * Verifica que el artículo se elimine correctamente.
     */
    @Test
    void testEliminarArticulo() {
        // Eliminar el artículo con ID 1
        boolean resultado = servicio.eliminarArticulo(1);

        // Verificar si el artículo fue eliminado correctamente
        assertTrue(resultado, "El artículo debería haberse eliminado correctamente.");
        assertEquals(0, servicio.listarArticulos().size(), "No debería haber artículos almacenados.");
    }

    /**
     * Prueba para consultar un artículo por su ID.
     * Verifica que se pueda consultar correctamente el artículo existente.
     */
    @Test
    void testConsultarArticulo() {
        // Consultar el artículo con ID 1
        Articulo articuloConsultado = servicio.consultarArticulo(1);

        // Verificar si se consultó el artículo correctamente
        assertNotNull(articuloConsultado, "El artículo debería existir.");
        assertEquals(1, articuloConsultado.getIdArticulo(), "El ID del artículo debería ser 1.");
    }

    /**
     * Prueba para actualizar un artículo existente.
     * Verifica que el artículo se actualice correctamente.
     */
    @Test
    void testActualizarArticulo() {
        // Crear un artículo actualizado
        Articulo articuloActualizado = new Articulo("Título Actualizado", "Autores Actualizados");
        articuloActualizado.setIdArticulo(1); // Mantener el mismo ID

        // Llamar al método actualizarArticulo
        boolean resultado = servicio.actualizarArticulo(articuloActualizado);

        // Verificar si el artículo fue actualizado correctamente
        assertTrue(resultado, "El artículo debería haberse actualizado correctamente.");

        // Consultar el artículo actualizado
        Articulo articuloConsultado = servicio.consultarArticulo(1);

        // Verificar si los cambios se aplicaron
        assertEquals("Título Actualizado", articuloConsultado.getTitulo(), "El título del artículo debería haberse actualizado.");
        assertEquals("Autores Actualizados", articuloConsultado.getAutores(), "Los autores deberían haberse actualizado.");
    }
}
