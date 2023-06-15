package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Consejo;
@Repository
public interface IConsejoRepository extends CrudRepository<Consejo, Long> {
	
	/**
	 * buequeda basado en la denominacion de pablaras.
	 * En MySQl este metodo se traduce como SELECT * FROM Alumno WHERE consj_estado = true
	 * @param estadoConsejo
	 * @return Se obtiene una lista de registros de consejo segun el estado
	 */
	public List<Consejo> findByEstadoConsejo(boolean estadoConsejo);
}
