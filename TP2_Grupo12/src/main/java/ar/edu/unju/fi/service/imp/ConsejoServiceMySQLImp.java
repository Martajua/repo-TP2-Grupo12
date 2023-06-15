package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;

@Service("consejoServiceMySQL")
public class ConsejoServiceMySQLImp implements IConsejoService {
	
	/*Objeto de la interfaz IConsejoRepository*/
	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> getListaConsejo() {
		return consejoRepository.findByEstadoConsejo(true);
	}
	
	/**
	 * Guarga en la tabla un objeto de tipo Consejo si el objeto no contiene una clave primaria @id en su atributo.
	 * Se agrega una nueva fila con todos los atributos del objeto en la base de datos y se le asigna un @id.
	 */
	@Override
	public void guardar(Consejo consejo) {
		consejoRepository.save(consejo);
	}
	
	@Override
	public Consejo buscar(Long num) {
		return consejoRepository.findById(num).get();
	}
	
	/**
	 * Si le envio un objeto de tipo Consejo que contiene en su atributo una clave primaria @id con un valor,
	 * lo que hace el metodo .save en este caso es buscar en la tabla el registro con ese @id y hacer una actualizacion.
	 */
	@Override
	public void modificar(Consejo consejo) {
		consejoRepository.save(consejo);
	}

	@Override
	public void eliminar(Consejo consejoEncontrado) {
		// eliminacion logica
		consejoEncontrado.setEstadoConsejo(false);
		consejoRepository.save(consejoEncontrado);

	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}

}
