
package co.edu.unicauca.distribuidos.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import co.edu.unicauca.distribuidos.core.capaAccesoADatos.models.ConferenciaEntity;
import java.text.SimpleDateFormat;

@Repository
public class ConfereciaRepository {

	private int pos;
	private ArrayList<ConferenciaEntity> listaDeConferencias; 

	public ConfereciaRepository() throws java.text.ParseException {
		this.listaDeConferencias = new ArrayList<ConferenciaEntity>();		
		cargarConferencias();
		pos=this.listaDeConferencias.size()+1;
	}

	public List<ConferenciaEntity> findAll() {
		System.out.println("Invocando a listaConferencias");
		return this.listaDeConferencias;
	}

	public ConferenciaEntity findById(Integer id) {
		System.out.println("Invocando a consultar una conferencia");
		ConferenciaEntity objConferencia = null;

		for (ConferenciaEntity conferencia : listaDeConferencias) {
			if (conferencia.getId() == id) {
				objConferencia = conferencia;
				break;
			}
		}

		return objConferencia;
	}

	public ConferenciaEntity save(ConferenciaEntity conferencia) {
		System.out.println("Invocando a almacenar conferencia");
		conferencia.setId(pos);
		ConferenciaEntity objConferencia = null;
		if (this.listaDeConferencias.add(conferencia)) {
			objConferencia = conferencia;
			pos++;
		}

		return objConferencia;
	}

	public ConferenciaEntity update(Integer id, ConferenciaEntity Conferencia) {
		System.out.println("Invocando a actualizar una conferencia");
		ConferenciaEntity objConferencia = null;

		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId() == id) {
				this.listaDeConferencias.set(i, Conferencia);
				objConferencia = Conferencia;
				break;
			}
		}

		return objConferencia;
	}

	public boolean delete(Integer id) {
		System.out.println("Invocando a eliminar una conferencia");
		boolean bandera = false;

		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId() == id) {
				this.listaDeConferencias.remove(i);
				bandera = true;
				break;
			}
		}

		return bandera;
	}

	private void cargarConferencias() throws java.text.ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ConferenciaEntity objConferencia1 = new ConferenciaEntity(1, "Matematicas", formatter.parse("10/12/2024") ,formatter.parse("10/14/2024"));
		this.listaDeConferencias.add(objConferencia1);
		ConferenciaEntity objConferencia2 = new ConferenciaEntity(2, "Lenguas" , formatter.parse("10/12/2024") ,formatter.parse("10/14/2024"));
		this.listaDeConferencias.add(objConferencia2);
		ConferenciaEntity objConferencia3 = new ConferenciaEntity(3, "Fisica", formatter.parse("10/12/2024") ,formatter.parse("10/14/2024"));
		this.listaDeConferencias.add(objConferencia3);
		ConferenciaEntity objConferencia4 = new ConferenciaEntity(4, "Ingles", formatter.parse("10/12/2024") ,formatter.parse("10/14/2024"));
		this.listaDeConferencias.add(objConferencia4);
	}

}
