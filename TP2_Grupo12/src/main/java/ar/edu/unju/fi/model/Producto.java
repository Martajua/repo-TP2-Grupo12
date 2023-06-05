package ar.edu.unju.fi.model;

/*
 *Aquí se muestran las librerias importadas que se utilizarán.
 * 
 */

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Component

/*
 * En esta clase se definen las variables que se van a utilizar el formulario de
 * la sección producto. Las variables declaradas son: nombre - codigo - precio -
 * categoria. descuento - precioFinal.
 * 
 * 
 */
public class Producto {
	@NotBlank(message = "Debe ingresar un nombre")
	private String nombre;
	@NotEmpty(message = "El código no puede ser vacío")
	private String codigo;
	@NotNull(message = "El precio no puede ser vacío")
	private double precio;
	@NotBlank(message = "Debe seleccionar una categoria")
	private String categoria;
	private byte descuento;
	private double precioFinal;

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

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Producto() {
		super();
	}

	public Producto(String nombre, String codigo, double precio, String categoria, byte descuento) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
	}

	public double calcularDescuento() { //
		return precioFinal = this.precio - ((this.precio * this.descuento) / 100);
	}

}
