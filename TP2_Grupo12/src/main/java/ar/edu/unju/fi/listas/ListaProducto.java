package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

@Component

public class ListaProducto {

	private List<Producto> productos;
	
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		
			
		productos.add(new Producto(1,"Pañoleta para perro (Pañopet", "2571", 3000.00, "PERRO ADULTO", (byte) 50));
		productos.add(new Producto(2,"Cucha para cachorro","1415",4000.00,"PERRO CACHORRO",(byte) 15));
		productos.add(new Producto(3,"Correa","2530",2500.00,"GATO",(byte) 10));
		productos.add(new Producto(4,"Jaulas","2105",8000.00,"PERRO ADULTO",(byte) 50));	
		
		for (Producto producto : productos) {
			   producto.calcularDescuento();
			}
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
