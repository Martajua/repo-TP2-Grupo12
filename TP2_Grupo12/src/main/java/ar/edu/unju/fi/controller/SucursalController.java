package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	ListaSucursal listaSucursales = new ListaSucursal();

	@GetMapping("sucursales")
	public String getSucursal() {
		return "sucursales";
	}
	
	@GetMapping("/listado")
	public String getListaSucursalPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		model.addAttribute("sucursal", new Sucursal());
		return "nueva_sucursal";
	}
	
//	@PostMapping("/guardar")
//	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursales)
//		ModelAndView modelView = new ModelAndView
//		
//		
//	}
}

