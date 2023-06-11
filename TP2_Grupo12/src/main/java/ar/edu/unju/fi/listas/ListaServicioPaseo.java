package ar.edu.unju.fi.listas;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.ServicioDePaseo;

@Component
public class ListaServicioPaseo {

	public static List<ServicioDePaseo> paseos=new ArrayList<ServicioDePaseo>();

	public static List<ServicioDePaseo> getListaServicioPaseo() {
		
		if (paseos.isEmpty()) {

			paseos.add(new ServicioDePaseo("Lunes", "9 a 12 - 16 a 18", "Juan Perez",1));
			paseos.add(new ServicioDePaseo("Martes", "9 a 12 - 16 a 18", "Lucas Diaz",2));
			paseos.add(new ServicioDePaseo("Miercoles", "9 a 12 - 16 a 18", "Juan Perez",3));
			paseos.add(new ServicioDePaseo("Jueves", "9 a 12 - 16 a 18", "Maria Gomez",4));
			paseos.add(new ServicioDePaseo("Viernes", "9 a 12 - 16 a 18", "Lucas Diaz",5));
			paseos.add(new ServicioDePaseo("Sabado", "9 a 12 - 16 a 18", "Roberto Vazquez",6));
		
		}
		return paseos;
	}

	public static ServicioDePaseo findAutoById(int idPaseo) {
		ServicioDePaseo servicioPaseo = new ServicioDePaseo();
		for(ServicioDePaseo serv: paseos) {
			if(idPaseo==serv.getIdPaseo()) {
				servicioPaseo=serv;
				break;
			}
		}
		return servicioPaseo;
	}

	public static void setIdPaseo(ServicioDePaseo paseo) {
		paseo.setIdPaseo(paseos.get(paseos.size()-1).getIdPaseo()+1);
		paseos.add(paseo);
	}
	
	public static void addServicioPaseo(ServicioDePaseo servicio) {
       paseos.add(servicio);
    }

	
	
}
