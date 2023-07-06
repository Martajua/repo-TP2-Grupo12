package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_id")
	private Long id;
	
	@Column(name = "cat_nombre")
	@NotBlank(message = "El nombre no debe estar vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
	
	@Column(name = "cat_estado")
	@NotNull(message = "El estado no puede ser nulo")
	private boolean estado;

	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Categoria(Long id, String nombre, boolean estado) {
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
