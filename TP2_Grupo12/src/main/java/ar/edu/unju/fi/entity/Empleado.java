package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name = "empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@Column(name = "emp_nombre")
	@NotBlank(message = "El nombre no debe estar vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
	
	@Column(name = "emp_apellido")
	@NotBlank(message = "El apellido no debe estar vacío")
    @Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
	private String apellido;
	
	@Column(name = "emp_domicilio")
	@NotBlank(message = "El domicilio no debe estar vacío")
	private String domicilio;
	
	@Column(name = "emp_dni")
	@NotNull(message = "El DNI no puede ser nulo")
    @Min(value = 1000000, message = "El DNI debe ser mayor o igual a 1000000")
    @Max(value = 99999999, message = "El DNI debe ser menor o igual a 99999999")
	private int dni;
	
	@Column(name = "emp_estado")
	private boolean estado;

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(Long id, String nombre, String apellido, String domicilio, int dni, boolean estado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.dni = dni;
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

}
