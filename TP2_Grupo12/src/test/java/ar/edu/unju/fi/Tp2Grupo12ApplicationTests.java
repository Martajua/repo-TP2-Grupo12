package ar.edu.unju.fi;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.ISucursalService;

@SpringBootTest
class Tp2Grupo12ApplicationTests {

	@Autowired
	@Qualifier("sucursalServiceMySQL")
	private ISucursalService sucursalService;

	@Autowired
	private ICommonService commonService;
	
	Sucursal sucursal;
	@Test
	void guardarSucursal() {
		sucursal=new Sucursal();
		sucursal.setDireccion("asdasda");
		sucursal.setEstadoSucu(true);
		sucursal.setFechaInicio(LocalDate.of(2010, 02, 19));
		sucursal.setHorario("9999");
		sucursal.setNombre("bababoy");
		sucursal.setProvincia("Jujuy");
		sucursal.setTelefono("12345678");
		sucursal.setId((long)3);
		sucursalService.guardar(sucursal);
	}

}
