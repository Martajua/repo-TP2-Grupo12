package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {

	@GetMapping("/inicioConsejo")
	public String getConsejo() {
		return "consejos";
	}
}
