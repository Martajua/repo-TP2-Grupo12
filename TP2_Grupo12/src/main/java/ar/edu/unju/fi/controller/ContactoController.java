package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

	@GetMapping("contactos") //el navegador responde a la peticion pasada que sería "contactos"
    public String getContacto() {
		return "contacto";
	}
}
