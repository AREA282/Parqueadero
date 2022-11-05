package com.parqueadero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.parqueadero.model.Celda;
import com.parqueadero.repository.CeldaDao;

@Service
public class CeldaService {

	@Autowired
	private CeldaDao celdaDao;
	
	public int consultarCeldasDisponibles() {
		 int id=1;
		 Celda celda = celdaDao.findById(id);
		 return (30 - celda.getCantidadCeldas());
	}
	
	
	public String agregarUnVehiculoCelda() {
		int id=1;
		Celda celda = celdaDao.findById(id);
		if(celda.getCantidadCeldas()>30) {
			return "Todas las celdas están ocupadas";
		}
		else 
		{
			celda.setCantidadCeldas(celda.getCantidadCeldas()+1);
			celdaDao.save(celda);
			return "Vehículo registrado";
		}

	}
	
	public String eliminarUnVehiculoCelda() {
		int id=1;
		Celda celda = celdaDao.findById(id);
		celda.setCantidadCeldas(celda.getCantidadCeldas()-1);
		celdaDao.save(celda);
		return "Vehículo retirado, celda liberada";
	}
	
	
}
