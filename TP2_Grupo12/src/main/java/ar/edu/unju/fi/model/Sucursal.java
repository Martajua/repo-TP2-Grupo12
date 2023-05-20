package ar.edu.unju.fi.model;

public class Sucursal {
	
	private String nombre;
	private String provincia;
	private String direccion;
	private String telefono;
	private String horario;
	
	public Sucursal() {
	}
	
	public Sucursal(String provincia, String nombre, String direccion, String telefono, String horario) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String geProvincia() {
		return provincia;
	}
	public void setRegion(String provincia) {
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
	
}
