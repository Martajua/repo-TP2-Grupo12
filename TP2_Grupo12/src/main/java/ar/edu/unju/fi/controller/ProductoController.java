package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {

	@GetMapping("producto")
	public String getProducto() {
		return "productos";
	}
}
