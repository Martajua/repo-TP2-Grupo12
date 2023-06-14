package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ServicioDePaseo;
import jakarta.validation.Valid;


public interface IServicioService {

	List<ServicioDePaseo> getListaServicioPaseo();
	
	void guardar(@Valid ServicioDePaseo paseo);
	
	ServicioDePaseo buscar(Long id);
	
	void modificar(ServicioDePaseo paseo);
	
	void eliminar(ServicioDePaseo paseoEncontrado);
	
	ServicioDePaseo getServPaseo();
}
