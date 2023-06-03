package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Component
public class ServicioDePaseo {
	@NotBlank(message="Debe seleccionar una dia")
	private String dia;
	@NotEmpty(message="El valor del horario no puede esta vacio")
	private String horario;
	@NotBlank(message="Debe seleccionar una paseador")
	private String paseador;
	@NotEmpty(message="El valor del id no puede esta vacio")
	private String idPaseo;
	
	public ServicioDePaseo() {
	}
	public ServicioDePaseo(String dia, String horario, String paseador, String idPaseo) {
		super();
		this.dia = dia;
		this.horario = horario;
		this.paseador = paseador;
		this.idPaseo = idPaseo;
	}
	
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getPaseador() {
		return paseador;
	}
	public void setPaseador(String paseador) {
		this.paseador = paseador;
	}
	public String getIdPaseo() {
		return idPaseo;
	}
	public void setIdPaseo(String idPaseo) {
		this.idPaseo = idPaseo;
	}
	
}
