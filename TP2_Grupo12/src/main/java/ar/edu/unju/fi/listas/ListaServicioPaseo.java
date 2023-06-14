package ar.edu.unju.fi.listas;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.ServicioDePaseo;

@Component
public class ListaServicioPaseo {

	private List<ServicioDePaseo> paseos;

	public ListaServicioPaseo() {
		
		paseos = new ArrayList<ServicioDePaseo>();
			paseos.add(new ServicioDePaseo("Lunes", "9 a 12 - 16 a 18", "Juan Perez",1));
			paseos.add(new ServicioDePaseo("Martes", "9 a 12 - 16 a 18", "Lucas Diaz",2));
			paseos.add(new ServicioDePaseo("Miercoles", "9 a 12 - 16 a 18", "Juan Perez",3));
			paseos.add(new ServicioDePaseo("Jueves", "9 a 12 - 16 a 18", "Maria Gomez",4));
			paseos.add(new ServicioDePaseo("Viernes", "9 a 12 - 16 a 18", "Lucas Diaz",5));
			paseos.add(new ServicioDePaseo("Sabado", "9 a 12 - 16 a 18", "Roberto Vazquez",6));
	}

	public List<ServicioDePaseo> getPaseos() {
		return paseos;
	}

	public void setPaseos(List<ServicioDePaseo> paseos) {
		this.paseos = paseos;
	}

}
