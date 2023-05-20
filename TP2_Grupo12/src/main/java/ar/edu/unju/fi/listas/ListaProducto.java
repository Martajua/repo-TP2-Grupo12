package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;



public class ListaProducto {

	private List<Producto> productos;
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		
		productos.add(new Producto("Pañoleta para perro (Pañopet", 2571, 3000.00, "PERRO ADULTO", (byte) 0));
		productos.add(new Producto("Cucha para cachorro",1415,4000.00,"PERRO CACHORRO",(byte) 15));
		productos.add(new Producto("Correa",2530,2500.00,"GATO",(byte) 10));
		productos.add(new Producto("Jaulas",2105,8000.00,"PERRO ADULTO",(byte) 50));
		
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
