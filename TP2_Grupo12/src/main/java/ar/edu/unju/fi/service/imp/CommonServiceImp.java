package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaHorario;
import ar.edu.unju.fi.listas.ListaProvincia;
import ar.edu.unju.fi.service.ICommonService;
@Service
public class CommonServiceImp implements ICommonService {
	
	@Autowired
	private ListaProvincia listaProvincia;
	
	@Autowired
	private ListaHorario listaHorarios;

	@Override
	public List<String> getProvincias() {
		return listaProvincia.getProvincias();
	}

	@Override
	public List<String> getHorarios() {
		return listaHorarios.getHorarios();
	}

}
