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
import ar.edu.unju.fi.listas.ListaServicioPaseo;
import ar.edu.unju.fi.model.ServicioDePaseo;
import jakarta.validation.Valid;

/**
 * 
 * En esta clase controladora se hace referencia a todo lo referido a la sección
 * de "Servicios de Paseos" en nuestro proyecto.
 * 
 * 
 **/
@Controller
@RequestMapping("/servicios")
public class ServicioDePaseoController {

	@Autowired
	ListaServicioPaseo listaPaseo;

	@Autowired
	private ServicioDePaseo servicios;

	/*
	 * Se realiza el cargado de la página "servicio de paseo"cuando realice la
	 * petición el cliente
	 */
	@GetMapping("inicioPaseo")
	public String getServicio(Model model) {
		model.addAttribute("servicio_de_paseo", listaPaseo.getPaseos());
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
		model.addAttribute("servicios", servicios);
		model.addAttribute("edicion", edicion);
		return "formPaseo";
	}

	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 * 
	 */

	@PostMapping("/guardarPaseo")
	public ModelAndView getGuardarPaseo(@Valid @ModelAttribute("servicios") ServicioDePaseo servicios,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("servicio_de_paseo");
		if (result.hasErrors()) {
			modelView.setViewName("formPaseo");
			modelView.addObject("servicios", servicios);
			return modelView;
		}

		listaPaseo.getPaseos().add(servicios);
		modelView.addObject("servicio_de_paseo", listaPaseo.getPaseos());
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
	public String getModificarPaseo(Model model, @PathVariable(value = "idPaseo") String idPaseo) {
		ServicioDePaseo paseoEncontrado = new ServicioDePaseo();
		boolean edicion = true;
		for (ServicioDePaseo servPaseo : listaPaseo.getPaseos()) {
			if (servPaseo.getIdPaseo().equals(idPaseo)) {
				paseoEncontrado = servPaseo;
				break;
			}
		}
		model.addAttribute("servicios", paseoEncontrado);
		model.addAttribute("edicion", edicion);
		return "formPaseo";
	}

	/*
	 * Aqui se reciben los datos enviados por el formularios a modificar
	 * 
	 */
	@PostMapping("/modificar")
	public String modificarPaseo(@ModelAttribute("servicios") ServicioDePaseo servicios) {
		for (ServicioDePaseo servPaseo : listaPaseo.getPaseos()) {
			if (servPaseo.getIdPaseo().equals(servicios.getIdPaseo())) {
				servPaseo.setIdPaseo(servicios.getIdPaseo());
				servPaseo.setPaseador(servicios.getPaseador());
				servPaseo.setHorario(servicios.getHorario());
				servPaseo.setDia(servicios.getDia());
			}
		}
		return "redirect:/servicios/inicioPaseo";
	}

	/*
	 * 
	 * Se elimina un registro de acuerdo al id seleccionado
	 * 
	 */

	@GetMapping("/eliminar/{idPaseo}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value = "idPaseo") String idPaseo) {

		for (ServicioDePaseo servPaseo : listaPaseo.getPaseos()) {
			if (servPaseo.getIdPaseo().equals(idPaseo)) {
				listaPaseo.getPaseos().remove(servPaseo);
				break;
			}
		}
		return "redirect:/servicios/inicioPaseo";
	}
}
