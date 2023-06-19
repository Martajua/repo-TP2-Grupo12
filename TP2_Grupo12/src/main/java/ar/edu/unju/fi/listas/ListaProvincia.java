package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaProvincia {
	private List<String> provincias;
	public ListaProvincia() {
		provincias = new ArrayList<String>();
		provincias.add("Jujuy");
		provincias.add("Salta");
	}
	/**
	 * Al llamar al método, se obtiene la lista de provincias almacenadas 
	 * en el objeto ListaProvincia.
	 * @return devuelve un objeto de tipo List<String> que contiene los nombres de las provincias.
	 */
	public List<String> getProvincias() {
		return provincias;
	}
	public void setProvincias(List<String> provincias) {
		this.provincias = provincias;
	}
	
}
