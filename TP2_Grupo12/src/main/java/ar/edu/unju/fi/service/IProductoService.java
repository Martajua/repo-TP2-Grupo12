package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;

public interface IProductoService {

	
	
	List<Producto> getLista();
	
	void guardar(Producto producto);

	Producto buscar(String id);

	void modificar(Producto producto);

	void eliminar(Producto productoEncontrado);

	Producto getProducto();
	
}
