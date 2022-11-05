package com.parqueadero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parqueadero.model.Celda;

@Repository
public interface CeldaDao extends JpaRepository<Celda, Integer>{

	Celda findByCantidadCeldas(int cantidadCeldas);
	
	Celda findById(int id);
}
