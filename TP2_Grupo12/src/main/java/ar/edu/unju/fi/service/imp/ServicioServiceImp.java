package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ServicioDePaseo;
import ar.edu.unju.fi.listas.ListaServicioPaseo;
import ar.edu.unju.fi.service.IServicioService;
import jakarta.validation.Valid;

@Service("servicioServiceImp")
public class ServicioServiceImp implements IServicioService{

	/*
	 * Lista de paseos
	 */
	@Autowired
	private ListaServicioPaseo listaPaseos;
	/*
	 * Nuevo paseo
	 */
	@Autowired
	private ServicioDePaseo paseo;
	
	@Override
	public List<ServicioDePaseo> getListaServicioPaseo() {
		return listaPaseos.getPaseos();
	}

	@Override
	public void guardar(@Valid ServicioDePaseo paseo) {
		listaPaseos.getPaseos().add(paseo);
	}

	@Override
	public ServicioDePaseo buscar(Long id) {
		ServicioDePaseo paseoEncontrado = null;
		for(ServicioDePaseo pas: listaPaseos.getPaseos()) {
			if (pas.getIdPaseo() == id) {
				paseoEncontrado = pas;
				break;
			}
		}
		return paseoEncontrado;
	}

	@Override
	public void modificar(ServicioDePaseo paseo) {
		for(ServicioDePaseo pas: listaPaseos.getPaseos()) {
			if(pas.getIdPaseo() == paseo.getIdPaseo()) {
				pas.setDia(paseo.getDia());
				pas.setHorario(paseo.getHorario());
				pas.setPaseador(paseo.getPaseador());
			}
		}
		
	}

	@Override
	public void eliminar(ServicioDePaseo paseoEncontrado) {
		listaPaseos.getPaseos().remove(paseoEncontrado);
		}

	@Override
	public ServicioDePaseo getServPaseo() {
		return paseo;
	}

}
