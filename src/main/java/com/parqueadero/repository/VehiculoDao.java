package com.parqueadero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parqueadero.model.Vehiculo;

@Repository
public interface VehiculoDao extends JpaRepository<Vehiculo, Integer>{

	@Query(value = "select * from vehiculo where placa = ?", nativeQuery = true)
	public Vehiculo findByPlaca(String placa);
	
	@Query(value = "select count(1) from vehiculo", nativeQuery = true)
	public int consultarVehiculosEstacionados();
	
}
