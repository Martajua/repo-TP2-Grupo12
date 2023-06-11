package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;

public interface IConsejoService {

	List<Consejo> getListaConsejo();
	
	void guardar(@Valid Consejo consejo);
	
	Consejo buscar(int num);
	
	void modificar(Consejo consejo);
	
	void eliminar(Consejo consejoEncontrado);
	
	Consejo getConsejo();
}
