package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class ServicioDePaseoController {

	@GetMapping("inicioPaseo")
	public String getServicio() {
		return "servicio_de_paseo";
	}
}
