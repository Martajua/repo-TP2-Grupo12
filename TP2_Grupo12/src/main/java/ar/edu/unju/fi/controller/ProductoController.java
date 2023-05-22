package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	//@GetMapping("/inicioProducto")
	//public String getProducto() {
	//	return "productos";
	//}
	
	
	ListaProducto listaProductos = new ListaProducto();
	
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("producto", new Producto());
		model.addAttribute("edicion", edicion);
		return "formProductos";
	}

	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("producto")Producto producto) {
		ModelAndView modelView = new ModelAndView("productos");
		listaProductos.getProductos().add(producto);
		modelView.addObject("productos", listaProductos.getProductos());
		return modelView;
	}
	
	@GetMapping("/buscar")
	public String getBuscarProductoPage(Model model, @PathVariable(value="codigo") String codigo) {
		Producto productoEncontrado = new Producto();
		boolean edicion=true;
		for(Producto prod : listaProductos.getProductos()) {
			if(prod.getCodigo().equals(codigo)) {
				productoEncontrado = prod;
				break;
			}
		}
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);
		return "formProducto";
	}
}
