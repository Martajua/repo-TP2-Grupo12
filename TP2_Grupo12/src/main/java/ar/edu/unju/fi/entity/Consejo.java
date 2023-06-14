package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import nonapi.io.github.classgraph.json.Id;

@Component
@Entity
@Table(name="consejos")
public class Consejo {
	
	/*
	 * @Id num es la clave primaria con valor incremental y secuencial
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consj_num")
	@NotNull(message = "El numero de consejo no puede esta vacio")
	private Long num;
	
	/*
	 * nullable = false no se permiten valores nulos
	 * */
	
	@Column(name="consj_titulo",length = 30,nullable = false)
	@NotEmpty(message = "El titulo no puede estar vacio")
	private String titulo;
	
	@Column(name="consj_msj",length = 100,nullable = false)
	@Size(min=10, max=100, message = "El mensaje debe contener entre 10 a 100 caracteres")
	private String mensaje;
	
	/*
	 * Atributo para trabajar con la eliminacion logica
	 * 
	 * */
	@Column(name="consj_estado")
	private boolean estadoConsejo;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
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

	public boolean isEstadoConsejo() {
		return estadoConsejo;
	}

	public void setEstadoConsejo(boolean estadoConsejo) {
		this.estadoConsejo = estadoConsejo;
	}

	public Consejo() {
	}

	public Consejo(Long num, String titulo, String mensaje, boolean estadoConsejo) {
		this.num = num;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.estadoConsejo = estadoConsejo;
	}

	
	
}
