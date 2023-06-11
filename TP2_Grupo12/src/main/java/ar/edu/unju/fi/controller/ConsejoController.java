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

import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {

	@Autowired
	private IConsejoService consejoService;
	
	@GetMapping("/inicioConsejo")
	public String getConsejoPage(Model model) {
		model.addAttribute("consejos", consejoService.getListaConsejo());
		return "consejos";
	}
	
	@GetMapping("/nuevoConsejo")
	public String getNuevoConsejoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("consejo", consejoService.getConsejo());
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
		consejoService.guardar(consejo);
		modelView.addObject("consejos", consejoService.getListaConsejo());
		return modelView;
	}
	
	@GetMapping("/modificar/{num}")
	public String getModificarConsejosPage(Model model, @PathVariable(value = "num") int num) {
		Consejo consejoEncontrado = consejoService.buscar(num);
		boolean edicion = true;
		model.addAttribute("consejo", consejoEncontrado);
		model.addAttribute("edicion", edicion);
		return "formConsejos";
	}
	
	@PostMapping("/modificar")

	public String modificarConsejos(@ModelAttribute("consejo") Consejo consejo, BindingResult result) {
		if (result.hasErrors()) {
	        return "formConsejos";
		}
		consejoService.modificar(consejo);
		return "redirect:/consejo/inicioConsejo";
	}
	
	@GetMapping("/eliminar/{num}")
	public String getEliminarConsejosPage(Model model, @PathVariable(value = "num") int num) {
		Consejo consejoEncontrado = consejoService.buscar(num);
		consejoService.eliminar(consejoEncontrado);
		return "redirect:/consejo/inicioConsejo";
	}
	
}

