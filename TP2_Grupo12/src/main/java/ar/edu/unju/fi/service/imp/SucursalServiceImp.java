package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements ISucursalService {

	@Autowired
	private ListaSucursal listaSucursales;

	@Autowired
	private Sucursal sucursal;

	public List<Sucursal> getLista() {

		return listaSucursales.getSucursales();
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void guardar(Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}

	public Sucursal buscar(Long id) {
		Sucursal sucursalEncontrada = null;
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if (sucu.getId().equals(id)) {
				sucursalEncontrada = sucu;
				break;
			}
		}
		return sucursalEncontrada;
	}

	public void modificar(Sucursal sucursal) {

		for (Sucursal sucu : listaSucursales.getSucursales()) {

			if (sucu.getId().equals(sucursal.getId())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setHorario(sucursal.getHorario());
				sucu.setNombre(sucursal.getNombre());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				sucu.setId(sucursal.getId());

			}

		}
	}

	public void eliminar(Sucursal sucursalEncontrada) {
		listaSucursales.getSucursales().remove(sucursalEncontrada);

	}
}
