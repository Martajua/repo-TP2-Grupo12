package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Sucursal;

public interface ISucursalService {

	List<Sucursal> getLista();

	void guardar(Sucursal sucursal);

	Sucursal buscar(String id);

	void modificar(Sucursal sucursal);

	void eliminar(Sucursal sucursalEncontrada);

	Sucursal getSucursal();
}
