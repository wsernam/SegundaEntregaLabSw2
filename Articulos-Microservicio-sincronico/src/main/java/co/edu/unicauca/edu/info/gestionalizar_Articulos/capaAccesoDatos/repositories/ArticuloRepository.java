package co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.models.ArticulosEntity;
import co.edu.unicauca.edu.info.gestionalizar_Articulos.capaAccesoDatos.models.ConferenciaEntity;

@Repository
public class ArticuloRepository {
    private ArrayList<ArticulosEntity> listaDeArticulos;
    
    public ArticuloRepository(){
        System.out.println("Invocando al contrsuctor sin parametros ");
        this.listaDeArticulos= new ArrayList<ArticulosEntity>();
        cargarArticulos();
    }

    public List<ArticulosEntity> ListarArticulos() {
		System.out.println("Invocando a lista Articulos");
		return this.listaDeArticulos;
	}
	
    public ArticulosEntity ConsultarArticulo(Integer codigo) {
		System.out.println("Invocando a consultar un Articulo");
		ArticulosEntity objArticulo = null;

		for (ArticulosEntity articulo : listaDeArticulos) {
			if (articulo.getIdArticulo() == codigo) {
				objArticulo = articulo;
				break;
			}
		}

		return objArticulo;
	}

    public ArticulosEntity AdicionarArticulo(ArticulosEntity articulo) {
		System.out.println("Invocando a Adicionar Articulo");
		ArticulosEntity objArticulo = null;
		if (this.listaDeArticulos.add(articulo)) {
			objArticulo = articulo;
		}

		return objArticulo;
	}

    public ArticulosEntity ActualizarArticulo(Integer codigo, ArticulosEntity articulo) {
		System.out.println("Invocando a actualizar un libro en la biblioteca");
		ArticulosEntity objArticulo = null;

		for (int i = 0; i < this.listaDeArticulos.size(); i++) {
			if (this.listaDeArticulos.get(i).getIdArticulo() == codigo) {
				this.listaDeArticulos.set(i, articulo);
				objArticulo = articulo;
				break;
			}
		}
		return objArticulo;
	}

    public boolean EliminarArticulo(Integer codigo) {
		System.out.println("Invocando a eliminar un libro");
		boolean bandera = false;

		for (int i = 0; i < this.listaDeArticulos.size(); i++) {
			if (this.listaDeArticulos.get(i).getIdArticulo() == codigo) {
				this.listaDeArticulos.remove(i);
				bandera = true;
				break;
			}
		}

		return bandera;
	}

	
    public List<ArticulosEntity> ListarArticulosDeCliente(Integer idConferencia) {
	System.out.println("Obteniendo los articulos desde el repositorio");
       	ArrayList<ArticulosEntity> listaArticulos= new ArrayList();
		for (int i = 0; i < this.listaDeArticulos.size(); i++) {
			List<ConferenciaEntity> listaConferencias=this.listaDeArticulos.get(i).getConferencias();
			for (int j = 0; j < listaConferencias.size(); j++) {
				if(listaConferencias.get(j).getId()==idConferencia)
				{					
					listaArticulos.add(this.listaDeArticulos.get(i));
					break;
				}
			}
		}
		System.out.println("lista retornada "+listaArticulos.size());
	   return listaArticulos;
    }

    private void cargarArticulos() {
		System.out.println("Cargando Articulos");
		ArrayList<ConferenciaEntity> listaClientesLibro1=  new ArrayList();
		ConferenciaEntity objCliente1= new ConferenciaEntity();
		objCliente1.setId(1);
		listaClientesLibro1.add(objCliente1);
		ConferenciaEntity objCliente2= new ConferenciaEntity();
		objCliente2.setId(2);
		listaClientesLibro1.add(objCliente2);


		ArrayList<ConferenciaEntity> listaClientesLibro2=  new ArrayList();
		ConferenciaEntity objCliente3= new ConferenciaEntity();
		objCliente3.setId(1);
		listaClientesLibro2.add(objCliente3);

		ArrayList<ConferenciaEntity> listaClientesLibro3=  new ArrayList();
		ConferenciaEntity objCliente4= new ConferenciaEntity();
		objCliente4.setId(1);
		listaClientesLibro3.add(objCliente4);
		ConferenciaEntity objCliente5= new ConferenciaEntity();
		objCliente5.setId(2);
		listaClientesLibro3.add(objCliente5);

		ArticulosEntity objLibro1 = new ArticulosEntity(1, "Frankenteis", "romeo, julia","Frankestein", listaClientesLibro1);
		this.listaDeArticulos.add(objLibro1);
		ArticulosEntity objLibro2 = new ArticulosEntity(2, "Frankenteis","romeo, julia", "Frankestein", listaClientesLibro2);
		this.listaDeArticulos.add(objLibro2);
		ArticulosEntity objLibro3 = new ArticulosEntity(3, "Frankenteis","romeo, julia", "Frankestein", listaClientesLibro3);
		this.listaDeArticulos.add(objLibro3);
    
		
	}

}
