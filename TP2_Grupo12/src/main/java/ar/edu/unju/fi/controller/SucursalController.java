package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

//En esta clase se hace referencia a las sucursales de nuestro proyecto
@Controller
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	@Qualifier("sucursalServiceMySQL")
	private ISucursalService sucursalService;

	@Autowired
	private ICommonService commonService;

	// método que realiza la carga de la vista de sucursales.
	@GetMapping("/listado")
	public String getListaSucursalPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		// retorna la vista sucursales
		return "sucursales";
	}

	// Carga la vista del formulario para realizar un alta del registro
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion = false;
		model.addAttribute("sucursal", sucursalService.getSucursal());
		model.addAttribute("provincias", commonService.getProvincias());
		model.addAttribute("horarios", commonService.getHorarios());
		model.addAttribute("edicion", edicion);
		return "formSucursal";
	}

//Recibe los datos enviados por el formulario y realiza el alta de un registro
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("sucursales");
		if (result.hasErrors()) {
			modelView.setViewName("formSucursal");
			modelView.addObject("provincias", commonService.getProvincias());
			modelView.addObject("horarios", commonService.getHorarios());
			modelView.addObject("sucursal", sucursal);
			return modelView;
		}
		sucursal.setEstadoSucu(true);// PRUEBA SETEAR PARA VER SI GUARDA
		//sucursal.setId((long) (sucursalService.getLista().size() + 1));// PRUEBA SETEAR PARA VER SI GUARDA
		sucursalService.guardar(sucursal);

		modelView.addObject("sucursales", sucursalService.getLista());
		modelView.setViewName("sucursales");
		return modelView;
	}

//método que carga un formulario con los datos seleccionados para realizar una modificación
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value = "id") Long id) {

		Sucursal sucursalEncontrada = sucursalService.buscar(id);
		boolean edicion = true;
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("provincias", commonService.getProvincias());
		model.addAttribute("horarios", commonService.getHorarios());
		model.addAttribute("edicion", edicion);
		return "formSucursal";
	}

	// método que realiza la modificación de un registro
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("sucursal") Sucursal sucursal, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("provincias", commonService.getProvincias());
			model.addAttribute("horarios", commonService.getHorarios());
			boolean edicion = true;
			model.addAttribute("edicion", edicion);
			return "formSucursal";
		}
		sucursalService.modificar(sucursal);
		return "redirect:/sucursal/listado";
	}

	// Se elimina un registro de acuerdo al id seleccionado
	@GetMapping("/eliminar/{id}")
	public String getEliminatSucursalPage(Model model, @PathVariable(value = "id") Long id) {
		Sucursal sucursalEncontrada = sucursalService.buscar(id);
		sucursalService.eliminar(sucursalEncontrada);
		return "redirect:/sucursal/listado";
	}
}
