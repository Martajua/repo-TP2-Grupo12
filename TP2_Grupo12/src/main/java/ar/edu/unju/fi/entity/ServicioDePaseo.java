package ar.edu.unju.fi.entity;

/*
 *Aquí se muestran las librerias importadas que se utilizarán.
 * 
 */

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
//import nonapi.io.github.classgraph.json.Id;

/*
 * En esta clase se definen las variables que se van a utilizar el
 * formulario de la sección servicio de paseo. Las variables declaradas son: día - horario - paseador - idPaseo.
 * 
 * 
 */
@Component
@Entity
@Table(name="paseos")
public class ServicioDePaseo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="paseo_id")
	private Long idPaseo;
	
	@Column(name="paseo_dia")
	@NotBlank(message = "Debe seleccionar una dia")
	private String dia;
	
	@Column(name="paseo_horario")
	@NotEmpty(message = "El valor del horario no puede esta vacio")
	private String horario;
	
	@Column(name="paseo_paseador")
	@NotBlank(message = "Debe seleccionar una paseador")
	private String paseador;

	/*
	 * Atributo para trabajar con la eliminacion logica
	 * 
	 * */
	@Column(name="paseo_estado")
	private boolean estadoPaseo;
	
	
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
	public Long getIdPaseo() {
		return idPaseo;
	}
	public void setIdPaseo(Long idPaseo) {
		this.idPaseo = idPaseo;
	}
	public boolean isEstadoPaseo() {
		return estadoPaseo;
	}
	public void setEstadoPaseo(boolean estadoPaseo) {
		this.estadoPaseo = estadoPaseo;
	}
	
	public ServicioDePaseo() {
	}
	
	public ServicioDePaseo(String dia, String horario, String paseador, Long idPaseo, boolean estadoPaseo) {
		super();
		this.dia = dia;
		this.horario = horario;
		this.paseador = paseador;
		this.idPaseo = idPaseo;
		this.estadoPaseo = estadoPaseo;
	}

}

