package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceImp")
public class ProductoServiceImp implements IProductoService {

	@Autowired
	private ListaProducto listaProducto;
	@Autowired
	private Producto producto;

	public List<Producto> getLista() {
		return listaProducto.getProductos();
	}

	public void guardar(Producto producto) {
		listaProducto.getProductos().add(producto);
		producto.calcularDescuento();
	}

	public Producto buscar(Long id) {
		Producto productoEncontrado = null;
		for (Producto prod : listaProducto.getProductos()) {
			if (prod.getCodigo().equals(id)) {
				productoEncontrado = prod;
				break;
			}
		}
		return productoEncontrado;
	}

	public void modificar(Producto producto) {
		for (Producto prod : listaProducto.getProductos()) {
			if (prod.getCodigo().equals(producto.getCodigo())) {
				prod.setCategoria(producto.getCategoria());
				prod.setCodigo(producto.getCodigo());
				prod.setNombre(producto.getNombre());
				prod.setDescuento(producto.getDescuento());
				prod.setPrecio(producto.getPrecio());
				prod.setPrecioFinal(producto.calcularDescuento());
			}

		}

	}

	public void eliminar(Producto productoEncontrado) {
		listaProducto.getProductos().remove(productoEncontrado);

	}

	public Producto getProducto() {
		return producto;
	}

}
