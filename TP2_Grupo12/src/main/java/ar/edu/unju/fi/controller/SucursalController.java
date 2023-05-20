package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SucursalController {

	@GetMapping("sucursales")
	public String getSucursal() {
		
		return "sucursales";
	}
}
