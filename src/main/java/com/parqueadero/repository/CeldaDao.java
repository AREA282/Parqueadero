package com.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parqueadero.model.Celda;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CeldaDao extends JpaRepository<Celda, Integer>{
	Celda findById(int id);

	@Query(nativeQuery = true, value = "select * from celdas  where vehiculo_id IS null")
	List<Celda> findCeldasLibres();

	@Query(nativeQuery = true, value = "select * from celdas  where vehiculo_id IS null order by id asc limit 1")
	Celda findPrimerCeldaLibre();

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE parqueadero.celdas SET vehiculo_id=null WHERE vehiculo_id= :id")
	int findCeldaVehiculoRetirar(Long id);

}
