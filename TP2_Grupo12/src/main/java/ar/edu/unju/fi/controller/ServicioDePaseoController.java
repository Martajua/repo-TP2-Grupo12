package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioDePaseoController {

	@GetMapping("servicios")
	public String getServicio() {
		return "servicio_de_paseo";
	}
}
