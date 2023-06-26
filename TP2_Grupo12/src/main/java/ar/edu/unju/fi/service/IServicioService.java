package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.ServicioDePaseo;

public interface IServicioService {

	List<ServicioDePaseo> getListaServicioPaseo();

	void guardar(ServicioDePaseo paseo);

	ServicioDePaseo buscar(Long id);

	void modificar(ServicioDePaseo paseo);

	void eliminar(ServicioDePaseo paseoEncontrado);

	ServicioDePaseo getServPaseo();
}
