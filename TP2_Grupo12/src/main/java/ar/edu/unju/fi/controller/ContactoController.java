package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contactos")
public class ContactoController {

	@GetMapping("/inicioContacto") //el navegador responde a la peticion pasada que sería "contactos"
    public String getContacto() {
		return "contacto";
	}
}
