package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.listas.ListaServicioPaseo;
import ar.edu.unju.fi.model.ServicioDePaseo;


@Controller
@RequestMapping("/servicios")
public class ServicioDePaseoController {
	
	@Autowired
	ListaServicioPaseo listaPaseo;
	
	@Autowired
	private ServicioDePaseo servicios;
	
	@GetMapping("inicioPaseo")
	public String getServicio(Model model) {
		model.addAttribute("servicio_de_paseo", listaPaseo.getPaseos());
		return "servicio_de_paseo";
	}
	
	@GetMapping("/nuevoPaseo")
	public String getNuevoPaseoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("servicios", servicios);
		model.addAttribute("edicion", edicion);
		return "formPaseo";
	}
	
	@PostMapping("/guardarPaseo")
	public ModelAndView getGuardarPaseo(@ModelAttribute("servicios")ServicioDePaseo servicios) {
		ModelAndView modelView = new ModelAndView("servicio_de_paseo");
		listaPaseo.getPaseos().add(servicios);
		modelView.addObject("servicio_de_paseo", listaPaseo.getPaseos());
		return modelView;
	}
	
	@GetMapping("/modificar/{idPaseo}")
	public String getModificarPaseo(Model model, @PathVariable(value="idPaseo")String idPaseo) {
		ServicioDePaseo paseoEncontrado= new ServicioDePaseo();
		boolean edicion=true;
		for(ServicioDePaseo servPaseo : listaPaseo.getPaseos()) {
			if(servPaseo.getIdPaseo().equals(idPaseo)) {
				paseoEncontrado= servPaseo;
				break;
			}
		}
		model.addAttribute("servicios", paseoEncontrado);
		model.addAttribute("edicion", edicion);
		return "formPaseo";
	}
	
	@PostMapping("/modificar")
	public String modificarPaseo(@ModelAttribute("servicios")ServicioDePaseo servicios){
		for(ServicioDePaseo servPaseo: listaPaseo.getPaseos()) {
			if(servPaseo.getIdPaseo().equals(servicios.getIdPaseo())) {
				servPaseo.setIdPaseo(servicios.getIdPaseo());
				servPaseo.setPaseador(servicios.getPaseador());
				servPaseo.setHorario(servicios.getHorario());
				servPaseo.setDia(servicios.getDia());
			}
		}
		return "redirect:/servicios/inicioPaseo";
	}
	
	@GetMapping("/eliminar/{idPaseo}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value="idPaseo")String idPaseo) {
		
		for(ServicioDePaseo servPaseo: listaPaseo.getPaseos()) {
			if(servPaseo.getIdPaseo().equals(idPaseo)) {
				listaPaseo.getPaseos().remove(servPaseo);
				break;
			}
		}
		return "redirect:/servicios/inicioPaseo";
	}
}
