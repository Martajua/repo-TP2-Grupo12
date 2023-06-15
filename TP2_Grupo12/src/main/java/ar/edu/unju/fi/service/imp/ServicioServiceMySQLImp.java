package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.ServicioDePaseo;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;
@Service("servicioServiceMySQL")
public class ServicioServiceMySQLImp implements IServicioService {
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private ServicioDePaseo servicio;
	
	@Override
	public List<ServicioDePaseo> getListaServicioPaseo() {
		return servicioRepository.findByEstadoPaseo(true);
	}

	@Override
	public void guardar(ServicioDePaseo paseo) {
		servicioRepository.save(paseo);

	}

	@Override
	public ServicioDePaseo buscar(Long id) {
		return servicioRepository.findById(id).get();
	}

	@Override
	public void modificar(ServicioDePaseo paseo) {
		servicioRepository.save(paseo);
	}

	@Override
	public void eliminar(ServicioDePaseo paseoEncontrado) {
		paseoEncontrado.setEstadoPaseo(false);
		servicioRepository.save(paseoEncontrado);
	}

	@Override
	public ServicioDePaseo getServPaseo() {
		return servicio;
	}

}
