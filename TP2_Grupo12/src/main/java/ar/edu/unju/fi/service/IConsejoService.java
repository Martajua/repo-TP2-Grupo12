package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;

public interface IConsejoService {

	List<Consejo> getListaConsejo();

	void guardar(Consejo consejo);

	Consejo buscar(Long num);

	void modificar(Consejo consejo);

	void eliminar(Consejo consejoEncontrado);

	Consejo getConsejo();
}
