package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Component
public class Contacto {
	@NotEmpty(message="El nombre no puede esta vacio")
	private String nombre;
	@Email(message="Ingrese un mail valido")
	private String email;
	@NotEmpty(message="La ciudad no puede esta vacio")
	private String ciudad;
	@NotEmpty(message="El mensaje no puede esta vacio")
	private String msj;
	
	public Contacto() {
	}

	public Contacto(String nombre, String email, String ciudad, String msj) {
		this.nombre = nombre;
		this.email = email;
		this.ciudad = ciudad;
		this.msj = msj;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
	
	
	
	
}
