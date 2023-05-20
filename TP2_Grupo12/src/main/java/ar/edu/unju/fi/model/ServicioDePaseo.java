package ar.edu.unju.fi.model;

public class ServicioDePaseo {

	private String dia;
	private String horario;
	private String paseador;
	
	public ServicioDePaseo() {
	}

	public ServicioDePaseo(String dia, String horario, String paseador) {
		this.dia = dia;
		this.horario = horario;
		this.paseador = paseador;
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
	
}
