package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "Provincias")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prov_id")
	private Long id;
	@Column(name = "prov_nombre")
	private String nombre;
	@Column(name = "prov_estado")
	private boolean estado;
	
	public Provincia() {
		// TODO Auto-generated constructor stub
	}
	
	public Provincia(Long id, String nombre, boolean estado) {
		this.id = id;
		this.nombre = nombre;
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
	
}
