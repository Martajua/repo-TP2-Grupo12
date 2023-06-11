package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.ServicioDePaseo;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

/**
 * 
 * En esta clase controladora se hace referencia a todo lo referido a la sección
 * de "Servicios de Paseos" en nuestro proyecto.
 * 
 * 
 **/
@Controller
@RequestMapping("/servicio")
public class ServicioDePaseoController {
	
	@Autowired
	private IServicioService paseoService;

	/*
	 * Se realiza el cargado de la página "servicio de paseo"cuando realice la
	 * petición el cliente
	 */
	
	@GetMapping("/inicioPaseo")
	public String getServicioDePaseo(Model model) {
		model.addAttribute("servicios", paseoService.getListaServicioPaseo());
		return "servicio_de_paseo";
	}
	
	/*
	 * Carga la vista del formulario. Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 * 
	 */
	
	@GetMapping("/nuevoPaseo")
	public String getNuevoPaseoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("servicio", paseoService.getServPaseo());
		model.addAttribute("edicion", edicion);
		return "formPaseo";
	}

	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 * 
	 */

	@PostMapping("/guardarPaseo")
	public ModelAndView postPageSavePaseo(@Valid @ModelAttribute("servicio") ServicioDePaseo servicio, BindingResult result) {
	    ModelAndView modelView = new ModelAndView("servicio_de_paseo");
	    if (result.hasErrors()) {
	        modelView.setViewName("formPaseo");
	        modelView.addObject("servicio", servicio);
	        return modelView;
	    }
	    paseoService.guardar(servicio);
	    modelView.addObject("servicios",paseoService.getListaServicioPaseo());
	    return modelView;
	}

	/*
	 * Carga la vista del formulario. Cuando la variable edición sea "verdadera" se
	 * va a cargar el formulario para modificar los datos de acuerdo al ID
	 * establecido
	 * 
	 * 
	 */

	@GetMapping("/modificar/{idPaseo}")
	public String getModificarPaseo(Model model, @PathVariable(value = "idPaseo") int idPaseo) {
	    ServicioDePaseo paseoEncontrado = paseoService.buscar(idPaseo);
	    boolean edicion = true;
	    model.addAttribute("servicio", paseoEncontrado);
	    model.addAttribute("edicion", edicion);
	    return "formPaseo";
	}

	/*
	 * Aqui se reciben los datos enviados por el formularios a modificar
	 * 
	 */
	@PostMapping("/modificar")
	public String modificarPaseo(@ModelAttribute("servicio") ServicioDePaseo servicio, Model model, BindingResult result) {
		if (result.hasErrors()) {
	        return "formPaseo";
		}
		paseoService.modificar(servicio);
		return "redirect:/servicio/inicioPaseo";
	}
	/*
	 * 
	 * Se elimina un registro de acuerdo al id seleccionado
	 * 
	 */
	@GetMapping("/eliminar/{idPaseo}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value = "idPaseo") int idPaseo) {
		 ServicioDePaseo paseoEncontrado = paseoService.buscar(idPaseo);
		 paseoService.eliminar(paseoEncontrado);
		return "redirect:/servicio/inicioPaseo";
	}
}


