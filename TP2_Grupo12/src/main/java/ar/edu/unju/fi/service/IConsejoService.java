package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;
import jakarta.validation.Valid;

public interface IConsejoService {

	List<Consejo> getListaConsejo();
	
	void guardar(@Valid Consejo consejo);
	
	Consejo buscar(Long num);
	
	void modificar(Consejo consejo);
	
	void eliminar(Consejo consejoEncontrado);
	
	Consejo getConsejo();
}
