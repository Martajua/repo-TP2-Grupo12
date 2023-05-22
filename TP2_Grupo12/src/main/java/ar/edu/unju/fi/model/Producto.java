package ar.edu.unju.fi.model;

public class Producto {
	
	private String nombre;
	private String codigo;
	private double precio;
	private String categoria;
	private byte descuento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public byte getDescuento() {
		return descuento;
	}
	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}

	
	public Producto(String nombre, String codigo, double precio, String categoria, byte descuento) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public double calcularDescuento() {
		return precio = this.precio - ((this.precio * this.descuento)/100);
	}
	

}
