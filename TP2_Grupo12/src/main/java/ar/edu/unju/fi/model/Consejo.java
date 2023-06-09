package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class Consejo {
	
	@NotNull(message = "El numero de consejo no puede esta vacio")
	private int num;
	@NotEmpty(message = "El titulo no puede estar vacio")
	private String titulo;
	@Size(min=10, max=100, message = "El mensaje debe contener entre 10 a 100 caracteres")
	private String mensaje;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	public Consejo() {
	}
	
	public Consejo(int num, String titulo,String mensaje) {
		this.num = num;
		this.titulo = titulo;
		this.mensaje = mensaje;
	}
}
