package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Service
public class ConsejoServiceImp implements IConsejoService {
	
	/*
	 * Lista de consejos
	 */
	@Autowired
	private ListaConsejo listaConsejos;
	/*
	 * Nuevo consejo
	 */
	@Autowired
	private Consejo consejo;

	@Override
	public List<Consejo> getListaConsejo() {
		return listaConsejos.getConsejos();
	}
	
	@Override
	public void guardar(@Valid Consejo consejo) {
		listaConsejos.getConsejos().add(consejo);
	}
	
	@Override
	public Consejo buscar(Long num) {
		Consejo consejoEncontrado = null;
		for(Consejo consj: listaConsejos.getConsejos()) {
			if(consj.getNum()==num) {
				consejoEncontrado = consj;
				break;
			}
		}
		return consejoEncontrado;
	}

	@Override
	public void modificar(Consejo consejo) {
		for(Consejo consj: listaConsejos.getConsejos()) {
			if(consj.getNum() == consejo.getNum()) {
				consj.setTitulo(consejo.getTitulo());
				consj.setMensaje(consejo.getMensaje());
			}
		}
	}

	@Override
	public void eliminar(Consejo consejoEncontrado) {
		listaConsejos.getConsejos().remove(consejoEncontrado);
		
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}
	

}
