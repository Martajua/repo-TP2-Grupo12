package ar.edu.unju.fi.entity;

/*
 *Aquí se muestran las librerias importadas que se utilizarán.
 * 
 */

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import nonapi.io.github.classgraph.json.Id;

@Component
@Entity
@Table(name="productos")
/*
 * En esta clase se definen las variables que se van a utilizar el formulario de
 * la sección producto. Las variables declaradas son: nombre - codigo - precio -
 * categoria. descuento - precioFinal.
 * 
 * 
 */
public class Producto {
	
	/*
	 * @Id codigo es la clave primaria con valor incremental y secuencial
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_codigo")
	@NotNull(message = "El código no puede ser vacío")
	private Long codigo;//se cambio el tipo del codigo era String ahora Long
	
	/*
	 * nullable = false no se permiten valores nulos
	 * */
	
	@Column(name="prod_nombre", length = 40,nullable = false)
	@NotBlank(message = "Debe ingresar un nombre")
	private String nombre;
	
	@Column(name="prod_precio", length = 15,nullable = false)
	@NotNull(message = "El precio no puede ser vacío")
	private double precio;
	
	@Column(name="prod_categoria")
	@NotBlank(message = "Debe seleccionar una categoria")
	private String categoria;
	
	@Column(name="prod_desc")
	private byte descuento;
	
	@Column(name="prod_prec_final")
	private double precioFinal;

	/*
	 * Atributo para trabajar con la eliminacion logica
	 * 
	 * */
	@Column(name="prod_estado")
	private boolean estadoProd;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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

	/*
	 * Se agregaron getter y setter del Atributo estado
	 * */
	public boolean isEstado() {
		return estadoProd;
	}

	public void setEstado(boolean estadoProd) {
		this.estadoProd = estadoProd;
	}

	
	public Producto() {
	}

	public Producto(Long codigo, String nombre, double precio, String categoria, byte descuento, double precioFinal,
			boolean estadoProd) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.precioFinal = precioFinal;
		this.estadoProd = estadoProd;
	}

	public double calcularDescuento() { //
		return precioFinal = this.precio - ((this.precio * this.descuento) / 100);
	}

}
