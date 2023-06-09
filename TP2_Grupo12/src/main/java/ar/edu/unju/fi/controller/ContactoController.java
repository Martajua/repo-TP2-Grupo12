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

import ar.edu.unju.fi.listas.ListaContacto;
import ar.edu.unju.fi.model.Contacto;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/contactos")
public class ContactoController {
	
	@Autowired
	ListaContacto listaContactos;
	
	@Autowired
	private Contacto contacto;

	@GetMapping("/inicioContacto") //el navegador responde a la peticion pasada que sería "contactos"
    public String getContacto(Model model) {
		model.addAttribute("contactos", contacto);
		return "contacto";
	}
	
//	@GetMapping("/nuevo")
//	public String getNuevoContactoPage(Model model) {
//		model.addAttribute("contactos", contacto);
//		return "contacto";
//	}
	
	@PostMapping("/enviar")
	public ModelAndView getEnviarContactoPage(@Valid @ModelAttribute("contactos") Contacto contacto,BindingResult result) {
		ModelAndView modelView = new ModelAndView("contacto");
		if(result.hasErrors()) {
			modelView.addObject("contactos",contacto);
			return modelView;
		}
		listaContactos.getContactos().add(contacto);
		modelView.addObject("contacto", listaContactos.getContactos());
		return modelView;
	}
}
