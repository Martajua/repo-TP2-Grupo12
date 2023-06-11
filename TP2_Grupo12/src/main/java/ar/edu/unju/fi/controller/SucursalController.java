package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	ListaSucursal listaSucursales;

	@Autowired
	private Sucursal sucursal;

	/*
	 * Se realiza el cargado de la página "sucursales"cuando realice la petición el
	 * cliente
	 */
	@GetMapping("/listado")
	public String getListaSucursalPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());

		return "sucursales";
	}

	/*
	 * Carga la vista del formulario. Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 * 
	 */

	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("edicion", edicion);
		return "formSucursal";
	}

	/*
	 * Recibe los datos enviados por el formulario y realiza el alta de un registro
	 * 
	 */

	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if (result.hasErrors()) {
			modelView.setViewName("formSucursal");
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}

	/*
	 * Carga la vista del formulario. Cuando la variable edición sea "verdadera" se
	 * va a cargar el formulario para modificar los datos de acuerdo al ID
	 * establecido
	 * 
	 * 
	 */
//
//	@GetMapping("/modificar/{id}")
//	public String getModificarSucursalPage(Model model, @PathVariable(value = "id") String id) {
//		Sucursal sucursalEncontrada = new Sucursal();
//		boolean edicion = true;
//		for (Sucursal sucu : listaSucursales.getSucursales()) {
//			if (sucu.getId().equals(id)) {
//				sucursalEncontrada = sucu;
//				break;
//			}
//		}
//		model.addAttribute("sucursal", sucursalEncontrada);
//		model.addAttribute("edicion", edicion);
//		return "formSucursal";
//	}

	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value = "id") String id) {
	    Sucursal sucursalEncontrada = new Sucursal();
	    boolean edicion = true;
	    for (Sucursal sucu : listaSucursales.getSucursales()) {
	        if (sucu.getId().equals(id)) {
	            sucursalEncontrada = sucu;
	            break;
	        }
	    }
	    model.addAttribute("sucursal", sucursalEncontrada);
	    model.addAttribute("edicion", edicion);
	    return "formSucursal";
	}
	
	/*
	 * Aqui se reciben los datos enviados por el formularios a modificar.
	 * 
	 */
//	@PostMapping("/modificar")
//	public String modificarSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
//		for (Sucursal sucu : listaSucursales.getSucursales()) {
//			if (sucu.getId().equals(sucursal.getId())) {
//				sucu.setId(sucursal.getId());
//				sucu.setDireccion(sucursal.getDireccion());
//				sucu.setHorario(sucursal.getHorario());
//				sucu.setNombre(sucursal.getNombre());
//				sucu.setProvincia(sucursal.getProvincia());
//				sucu.setTelefono(sucursal.getTelefono());
//			}
//		}
//		return "redirect:/sucursal/listado";
//	}

	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal") @Valid Sucursal sucursal, BindingResult result) {
	    if (result.hasErrors()) {
	        return "formSucursal";
	    }
	    for (Sucursal sucu : listaSucursales.getSucursales()) {
	        if (sucu.getId().equals(sucursal.getId())) {
	            sucu.setId(sucursal.getId());
	            sucu.setDireccion(sucursal.getDireccion());
	            sucu.setHorario(sucursal.getHorario());
	            sucu.setNombre(sucursal.getNombre());
	            sucu.setProvincia(sucursal.getProvincia());
	            sucu.setTelefono(sucursal.getTelefono());
	        }
	    }
	    return "redirect:/sucursal/listado";
	}

	
	/*
	 * 
	 * Se elimina un registro de acuerdo al id seleccionado
	 * 
	 */
	@GetMapping("/eliminar/{id}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value = "id") String id) {

		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(id)) {
				listaSucursales.getSucursales().remove(sucu);
				break;
			}
		}
		return "redirect:/sucursal/listado";
	}
}
