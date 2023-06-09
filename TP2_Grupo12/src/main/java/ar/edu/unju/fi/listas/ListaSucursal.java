package ar.edu.unju.fi.listas;

import java.util.List;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Sucursal;

@Component
public class ListaSucursal {

	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();

		sucursales.add(new Sucursal("Jujuy", "CASA CENTRAL", "Av. Fuerza Aérea N°200 - B° Alto Comedero", "3885 840391", "Lunes a Sábados de 9 a 21 hs","01-01"));
		sucursales.add(new Sucursal("Jujuy", "SUCURSAL LAVALLE", "Lavalle N°222- Local A", "3885 840394", "Lunes a Sábados de 9 a 22 hs","01-02"));
		sucursales.add(new Sucursal("Jujuy", "SUCURSAL PALPALÁ", "Av. Hipólito Yrigoyen N°163 - B° Carolina", "3884 072167", "Lunes a Sábados de 9 a 13 hs - 17 a 21hs","01-03"));
		
		sucursales.add(new Sucursal("Salta", "SUCURSAL INDEPENDENCIA", "Catamarca N° 1397 esq. Independencia", "3875 642182", "Lunes a Sábados de 9 a 21 hs","02-01"));
		sucursales.add(new Sucursal("Salta", "SUCURSAL SAN MARTIN 1", "San Martin N° 73", "3874 857719", "Lunes a Sábados de 10 a 22 hs","02-02"));
		sucursales.add(new Sucursal("Salta", "SUCURSAL MENDOZA", "Mendoza N° 570", "3875 690295", "Lunes a Sábados de 9 a 21hs","02-03"));
		sucursales.add(new Sucursal("Salta", "SUCURSAL SAN MARTIN 2", "San Martin N° 868", "3876 134119", "Lunes a Sábados de 10 a 22 hs","02-04"));
	}
	
	public List<Sucursal> getSucursales(){
		return sucursales;
	}
	
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
 }
