package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {

	@Autowired
	ListaConsejo listaConsejos;
	
	@Autowired
	private Consejo consejo;
	
	@GetMapping("/inicioConsejo")
	public String getConsejoPage(Model model) {
		model.addAttribute("consejos", listaConsejos.getConsejos());
		
		return "consejos";
	}
	
	@GetMapping("/nuevoConsejo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consejo", consejo);
		model.addAttribute("edicion", edicion);
		return "formConsejos";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		ModelAndView modelView = new ModelAndView("consejos");
		if (result.hasErrors()) {
			modelView.setViewName("formConsejos");
			modelView.addObject("consejo", consejo);
			return modelView;
		}
		listaConsejos.getConsejos().add(consejo);
		modelView.addObject("consejos", listaConsejos.getConsejos());
		return modelView;
	}
	
	@GetMapping("/modificar/{num}")
	public String getModificarConsejosPage(Model model, @PathVariable(value = "num") int num) {
		Consejo consejoEncontrado = new Consejo();
		boolean edicion = true;
		for (Consejo consj : listaConsejos.getConsejos()) {
			if (consj.getNum() == num) {
				consejoEncontrado = consj;
				break;
			}
		}
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "formConsejos";
	}
	
	@PostMapping("/modificar")

	public String modificarConsejos(@ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		if (result.hasErrors()) {
	        return "formConsejos";
		}
		for (Consejo consj : listaConsejos.getConsejos()) {
			if (consj.getNum() == consejo.getNum()){
				consj.setNum(consejo.getNum());
				consj.setTitulo(consejo.getTitulo());
				consj.setMensaje(consejo.getMensaje());
			}
		}
		return "redirect:/consejo/inicioConsejo";
	}
	
	@GetMapping("/eliminar/{num}")
	public String getEliminarConsejosPage(Model model, @PathVariable(value = "num") int num) {

		for (Consejo consj: listaConsejos.getConsejos()) {
			if (consj.getNum() == num) {
				listaConsejos.getConsejos().remove(consj);
				break;
			}
		}
		return "redirect:/consejo/inicioConsejo";
	}
	
}
