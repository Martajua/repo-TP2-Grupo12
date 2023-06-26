package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Contacto;
import ar.edu.unju.fi.listas.ListaContacto;
import jakarta.validation.Valid;

//En esta clase se hace referencia a la sección de contáctos de nuestro proyecto
@Controller
@RequestMapping("/contactos")
public class ContactoController {

	@Autowired
	ListaContacto listaContactos;

	@Autowired
	private Contacto contacto;

	// el navegador responde a la peticion pasada que sería "contactos"
	@GetMapping("/inicioContacto")
	public String getContacto(Model model) {
		model.addAttribute("contactos", contacto);
		return "contacto";
	}

	// método que realiza el envío de un contacto.
	@PostMapping("/enviar")
	public ModelAndView getEnviarContactoPage(@Valid @ModelAttribute("contactos") Contacto contacto,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("contacto");
		if (result.hasErrors()) {
			modelView.addObject("contactos", contacto);
			return modelView;
		}
		listaContactos.getContactos().add(contacto);
		modelView.addObject("contacto", listaContactos.getContactos());
		return modelView;
	}
}
