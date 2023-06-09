package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.ServicioDePaseo;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

//En esta clase se hace referencia a los servicios de paseos de nuestro proyecto
@Controller
@RequestMapping("/servicio")
public class ServicioDePaseoController {

	@Autowired
	@Qualifier("servicioServiceMySQL")
	private IServicioService paseoService;

	// método que realiza el cargado de la vista servicio de paseo
	@GetMapping("/inicioPaseo")
	public String getServicioDePaseo(Model model) {
		model.addAttribute("servicios", paseoService.getListaServicioPaseo());
		return "servicio_de_paseo";
	}

	// método que realiza la carga del formulario para realizar un alta de paseo
	@GetMapping("/nuevoPaseo")
	public String getNuevoPaseoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("servicio", paseoService.getServPaseo());
		model.addAttribute("edicion", edicion);
		// retorna el formulario
		return "formPaseo";
	}

	// método que recibe los datos enviados y realiza un alta del registro
	@PostMapping("/guardarPaseo")
	public ModelAndView postPageSavePaseo(@Valid @ModelAttribute("servicio") ServicioDePaseo servicio,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("servicio_de_paseo");
		if (result.hasErrors()) {
			modelView.setViewName("formPaseo");
			modelView.addObject("servicio", servicio);
			return modelView;
		}
		paseoService.guardar(servicio);
		modelView.addObject("servicios", paseoService.getListaServicioPaseo());
		return modelView;
	}

	// método que carga la vista del formulario, carga los datos enviados a
	// modificar.
	@GetMapping("/modificar/{idPaseo}")
	public String getModificarPaseo(Model model, @PathVariable(value = "idPaseo") Long idPaseo) {
		ServicioDePaseo paseoEncontrado = paseoService.buscar(idPaseo);
		boolean edicion = true;
		model.addAttribute("servicio", paseoEncontrado);
		model.addAttribute("edicion", edicion);
		return "formPaseo";
	}

	// método que recibe los datos a modificar
	@PostMapping("/modificar")
	public String modificarPaseo(@ModelAttribute("servicio") ServicioDePaseo servicio, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			return "formPaseo";
		}
		paseoService.modificar(servicio);
		return "redirect:/servicio/inicioPaseo";
	}

	// método que elimina un registo de acuerdo a un id seleccionado
	@GetMapping("/eliminar/{idPaseo}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value = "idPaseo") Long idPaseo) {
		ServicioDePaseo paseoEncontrado = paseoService.buscar(idPaseo);
		paseoService.eliminar(paseoEncontrado);
		return "redirect:/servicio/inicioPaseo";
	}
}
