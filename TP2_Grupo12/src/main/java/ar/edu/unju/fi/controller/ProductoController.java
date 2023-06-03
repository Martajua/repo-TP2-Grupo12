package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ListaProducto listaProductos;
	
	@Autowired
	private Producto producto;
	
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", listaProductos.getProductos());
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("producto", producto);
		model.addAttribute("edicion", edicion);
		return "formProductos";
	}

	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("productos")Producto producto) {
		ModelAndView modelView = new ModelAndView("productos");
		listaProductos.getProductos().add(producto);
		modelView.addObject("productos", listaProductos.getProductos());
		modelView.addObject("produtos", producto.calcularDescuento());
		return modelView;
	}
	
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value="codigo")String codigo) {
		Producto productoEncontrado = new Producto();
		boolean edicion = true;
		for(Producto prod : listaProductos.getProductos()) {
			if(prod.getCodigo().equals(codigo)) {
				productoEncontrado = prod;
				break;
			}
		}
		model.addAttribute("producto",productoEncontrado);
		model.addAttribute("edicion",edicion);
		return "formProductos";
	}
	
	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute("producto")Producto producto) {
		for(Producto prod : listaProductos.getProductos()) {
			if(prod.getCodigo().equals(producto.getCodigo())){
				prod.setCodigo(producto.getCodigo());
				prod.setCategoria(producto.getCategoria());
				prod.setNombre(producto.getNombre());
				prod.setPrecio(producto.getPrecio());
				prod.setDescuento(producto.getDescuento());
				prod.setPrecioFinal(producto.calcularDescuento());
				
			}
		}
	return 	"redirect:/producto/listado";
	}
	
	@GetMapping("eliminar/{codigo}")
	public String getEliminarProductoPaga(Model model, @PathVariable(value="codigo")String codigo) {
		for(Producto prod: listaProductos.getProductos()) {
			if(prod.getCodigo().equals(codigo)) {
				listaProductos.getProductos().remove(prod);
				break;
			}
		}
		return "redirect:/producto/listado";
	}
	
}
