package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.ServicioDePaseo;
@Repository
public interface IServicioRepository extends CrudRepository<ServicioDePaseo, Long> {
	
	public List<ServicioDePaseo> findByEstadoPaseo(boolean estadoPaseo);
}
