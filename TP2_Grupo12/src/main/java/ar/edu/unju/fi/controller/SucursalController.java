package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;



@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	ListaSucursal listaSucursales = new ListaSucursal();
	
	@GetMapping("/listado")
	public String getListaSucursalPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion=false;
		model.addAttribute("sucursal", new Sucursal());
		model.addAttribute("edicion", edicion);
		return "formSucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
		ModelAndView modelView = new ModelAndView("sucursales");
		listaSucursales.getSucursales().add(sucursal);
		modelView.addObject("sucursales", listaSucursales.getSucursales());
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="id")String id) {
		Sucursal sucursalEncontrada = new Sucursal();
		boolean edicion=true;
		for(Sucursal sucu : listaSucursales.getSucursales()) {
			if(sucu.getId().equals(id)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "formSucursal";
	}
	
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursal){
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getId().equals(sucursal.getId())) {
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
	
	@GetMapping("/eliminar/{id}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value="id")String id) {
		
		for(Sucursal sucu: listaSucursales.getSucursales()) {
			if(sucu.getId().equals(id)) {
				listaSucursales.getSucursales().remove(sucu);
				break;
			}
		}
		return "redirect:/sucursal/listado";
	}
}

