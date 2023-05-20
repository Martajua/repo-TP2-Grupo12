package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Contacto;

public class ListaContacto {

	private List<Contacto> contactos;
		public ListaContacto() {
			contactos = new ArrayList<Contacto>();
			
			contactos.add(new Contacto());
	}

}
