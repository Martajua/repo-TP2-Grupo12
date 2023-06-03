package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Contacto {

	private String nombre;
	private String email;
	private String ciudad;
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
