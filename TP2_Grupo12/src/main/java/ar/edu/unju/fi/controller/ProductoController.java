package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
/**
 * 
 * En esta clase controladora se hace referencia a todo lo referido a la sección
 * de "productos" en nuestro proyecto.
 * 
 * 
 **/
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	/*
	 * Aquí se recibe la petición del cliente y se devuelve la vista "productos" por
	 * petición "@GetMapping"
	 * 
	 */

	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos", productoService.getLista());
		return "productos";
	}

	/*
	 * Carga la vista del formulario. Cuando la variable edición sea falsa se va a
	 * cargar el formulario para realizar un alta
	 * 
	 */

	@GetMapping("/nuevo")
	public String getNuevoProductoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("producto", productoService.getProducto());
		model.addAttribute("edicion", edicion);
		return "formProductos";
	}

	/*
	 * 
	 * Recibe los datos pasados en el formulario por "post" y realiza el alta de
	 * cada dato ingresado.
	 * 
	 */

	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto") Producto producto,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView("productos");
		if (result.hasErrors()) {
			modelView.setViewName("formProductos");
			modelView.addObject("producto", producto);
			return modelView;
		}
		productoService.guardar(producto);
		modelView.addObject("productos", productoService.getLista());
		return modelView;
	}

	/*
	 * Carga la vista del formulario. Cuando la variable edición sea "verdadera" se
	 * va a cargar el formulario para modificar los datos de acuerdo al código
	 * establecido
	 * 
	 * 
	 */

	@GetMapping("/modificar/{codigo}")
	public String getModificarProductoPage(Model model, @PathVariable(value = "codigo") String codigo) {
		Producto productoEncontrado = productoService.buscar(codigo);
		boolean edicion = true;
		model.addAttribute("producto", productoEncontrado);
		model.addAttribute("edicion", edicion);
		return "formProductos";
	}

	/*
	 * 
	 * Una vez ingresado los datos se modifican
*/

	@PostMapping("/modificar")
	public String modificarProducto(@ModelAttribute("producto") Producto producto, BindingResult result) {
		if (result.hasErrors()) {
			return "formSucursal";
		}
		productoService.modificar(producto);
		return "redirect:/producto/listado";
	}

	/*
	 * 
	 * Se elimina un registro de acuerdo al código seleccionado
	 * 
	 */
	@GetMapping("eliminar/{codigo}")
	public String getEliminarProductoPaga(Model model, @PathVariable(value = "codigo") String codigo) {
		Producto productoEncontrado = productoService.buscar(codigo);
		productoService.eliminar(productoEncontrado);
		return "redirect:/producto/listado";
	}

}
