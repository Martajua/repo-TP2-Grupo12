package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Contacto;

@Component
public class ListaContacto {

	private List<Contacto> contactos;
		public ListaContacto() {
			contactos = new ArrayList<Contacto>();
			
			contactos.add(new Contacto());
	}

}
