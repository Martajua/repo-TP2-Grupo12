package ar.edu.unju.fi.listas;

import java.util.List;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class ListaSucursal {

	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales = new ArrayList<Sucursal>();

		sucursales.add(new Sucursal((long) 1, "CASA CENTRAL", "Jujuy", "Av. Fuerza Aérea N°200 - B° Alto Comedero", "3885 840391", "Lunes a Sábado de 9 a 22", LocalDate.of(2000, 12, 03), true));
		sucursales.add(new Sucursal((long) 2,"SUCURSAL LAVALLE", "Jujuy", "Lavalle N°222- Local A", "3885 840394", "Lunes a Sábado de 9 a 22",LocalDate.of(2005, 10, 13), true));
		sucursales.add(new Sucursal((long) 3,"SUCURSAL PALPALÁ", "Jujuy", "Av. Hipólito Yrigoyen N°163 - B° Carolina", "3884 072167", "Lunes a Sábado de 9 a 22",LocalDate.of(2010, 02, 19), true));
		
		sucursales.add(new Sucursal((long) 4,"SUCURSAL INDEPENDENCIA", "Salta", "Catamarca N° 1397 esq. Independencia", "3875 642182", "Lunes a Viernes de 9 a 22",LocalDate.of(2002, 07, 16), true));
		sucursales.add(new Sucursal((long) 5,"SUCURSAL SAN MARTIN 1", "Salta", "San Martin N° 73", "3874 857719", "Lunes a Viernes de 9 a 22",LocalDate.of(2008, 05, 02), true));
		sucursales.add(new Sucursal((long) 6,"SUCURSAL MENDOZA", "Salta", "Mendoza N° 570", "3875 690295", "Lunes a Viernes de 9 a 22",LocalDate.of(2013, 9, 22), true));
		sucursales.add(new Sucursal((long) 7,"SUCURSAL SAN MARTIN 2", "Salta", "San Martin N° 868", "3876 134119", "Lunes a Viernes de 9 a 22",LocalDate.of(2011, 11, 22), true));
	}
	
	public List<Sucursal> getSucursales(){
		return sucursales;
	}
	
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
 }
