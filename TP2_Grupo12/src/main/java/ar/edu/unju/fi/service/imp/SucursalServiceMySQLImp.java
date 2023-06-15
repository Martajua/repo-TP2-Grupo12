package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
@Service("sucursalServiceMySql")
public class SucursalServiceMySQLImp implements ISucursalService {
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;

	@Override
	public List<Sucursal> getLista() {
		return sucursalRepository.findByEstadoSucu(true);
	}

	@Override
	public void guardar(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

	@Override
	public Sucursal buscar(Long id) {
		return sucursalRepository.findById(id).get();
	}

	@Override
	public void modificar(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		sucursalEncontrada.setEstadoSucu(false);
		sucursalRepository.save(sucursalEncontrada);
	}

	@Override
	public Sucursal getSucursal() {
		return sucursal;
	}

}
