package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Component
public class Sucursal {
	
	@NotEmpty(message="El valor del nombre no puede esta vacio")
	private String nombre;
	@NotBlank(message="Debe seleccionar una provincia")
	private String provincia;
	@Size(min=5, max=100, message="La direccion debe contener entre 5 y 100 caractres")
	private String direccion;
	@Size(min=10, max=15, message="El numero de telefono debe contener entre 10 y 15 caracteres")
	private String telefono;
	@NotEmpty(message="El valor del horario no puede esta vacio")
	private String horario;
	@NotEmpty(message="El valor del Id no puede esta vacio")
	private String id;
	
	public Sucursal() {
	}
	public Sucursal(String provincia,String nombre,  String direccion, String telefono, String horario, String id) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
