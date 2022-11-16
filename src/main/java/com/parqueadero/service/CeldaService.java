package com.parqueadero.service;

import com.parqueadero.model.Vehiculo;
import com.parqueadero.repository.VehiculoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.parqueadero.model.Celda;
import com.parqueadero.repository.CeldaDao;

import java.util.List;

@Service
public class CeldaService {

	@Autowired
	private CeldaDao celdaDao;

	@Autowired
	private VehiculoDao vehiculoDao;
	
	public int consultarCeldasDisponibles() {

		return celdaDao.findCeldasLibres().size();
	}

	public List<Celda> consultarTodasCeldas() {

		return celdaDao.findAll();
	}
	
	
	public String agregarUnVehiculoCelda(@RequestParam String placa) {
		Celda celda = celdaDao.findPrimerCeldaLibre();
		Vehiculo vehiculo = vehiculoDao.findByPlaca(placa);
		celda.setVehiculo(vehiculo);
		celdaDao.save(celda);

		return "Vehiculo asignado a la celda id: "+ celda.getId();
	}
	
	public String retirarVehiculo(@RequestParam String placa) {
		Vehiculo vehiculo = vehiculoDao.findByPlaca(placa);
		Long id = vehiculo.getId();
		System.out.println(id);
		try {
			celdaDao.findCeldaVehiculoRetirar(id);
		}catch (Exception ex){
			System.out.println(ex);
		}

		return "Celda liberada";
	}
	
	
}
