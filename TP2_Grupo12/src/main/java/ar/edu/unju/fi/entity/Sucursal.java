package ar.edu.unju.fi.entity;
/*
 *Aquí se muestran las librerias importadas que se utilizarán.
 * 
 */

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
//import nonapi.io.github.classgraph.json.Id;

/*
 * En esta clase se definen las variables que se van a utilizar el
 * formulario de la sección sucursal. Las variables declaradas son: nombre - provincia - direccion - telefono-
 * horario - id.
 * 
 * 
 */
@Component
@Entity
@Table(name="sucursales")
public class Sucursal {

	/*
	 * @Id codigo es la clave primaria con valor incremental y secuencial
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sucu_id")
	@NotEmpty(message = "El valor del horario no puede esta vacio")
	private Long id;

	/*
	 * nullable = false no se permiten valores nulos
	 * */
	
	@Column(name="sucu_nombre")
	@NotEmpty(message = "El valor del nombre no puede esta vacio")
	private String nombre;
	
	@Column(name="sucu_provincia")
	@NotBlank(message = "Debe seleccionar una provincia")
	private String provincia;
	
	@Column(name="sucu_direccion",length = 40,nullable = false)
	@Size(min = 5, max = 100, message = "La direccion debe contener entre 5 y 100 caractres")
	private String direccion;
	
	@Column(name="sucu_telefono",length = 15,nullable = false)
	@Size(min = 10, max = 15, message = "El numero de telefono debe contener entre 10 y 15 caracteres")
	private String telefono;
	
	@Column(name="sucu_horario")
	@NotBlank(message = "Debe seleccionar una opcion")
	private String horario;
	
	/*
	 * Se agrego el atributo fechaInicio
	 * 
	 * */
	
	@Column(name="sucu_fecha_inicio")
	private LocalDate fechaInicio;
	
	/*
	 * Atributo para trabajar con la eliminacion logica
	 * 
	 * */
	@Column(name="sucu_estado")
	private boolean estadoSucu;
	
	
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
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public boolean isEstadoSucu() {
		return estadoSucu;
	}
	public void setEstadoSucu(boolean estadoSucu) {
		this.estadoSucu = estadoSucu;
	}

	public Sucursal() {
	}
	public Sucursal(Long id, String nombre, String provincia,String direccion, String telefono, String horario, LocalDate fechaInicio,
			boolean estadoSucu) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		this.fechaInicio = fechaInicio;
		this.estadoSucu = estadoSucu;
	}
	
	

	

}
