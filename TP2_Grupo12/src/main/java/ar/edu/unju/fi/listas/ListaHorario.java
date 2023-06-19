package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaHorario {
	private List<String> horarios;
	public ListaHorario() {
		horarios = new ArrayList<String>();
		horarios.add("Lunes a Viernes de 9 a 22");
		horarios.add("Lunes a Sábado de 9 a 22");
	}
	
	/**
	 * Al llamar al método, se obtiene la lista de horarios almacenadas 
	 * en el objeto ListaHorarios.
	 * @return devuelve un objeto de tipo List<String> que contiene los nombres de los Horarios.
	 */
	public List<String> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}
}
	
