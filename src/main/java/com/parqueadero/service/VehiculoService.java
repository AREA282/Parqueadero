package com.parqueadero.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.parqueadero.model.Vehiculo;
import com.parqueadero.repository.CeldaDao;
import com.parqueadero.repository.VehiculoDao;

@Service
public class VehiculoService {

	@Autowired
	private VehiculoDao vehiculoDao;
	
	@Autowired
	private CeldaService celdaService;
	
	public void registrarVehiculo() {
		
	}
	
	public Vehiculo consultarPlaca(@RequestParam String placa){
		Vehiculo vehiculo = vehiculoDao.findByPlaca(placa);
		return vehiculo;
	}
	
	public List<Vehiculo> consultarTodo(){
		List<Vehiculo> vehiculos = vehiculoDao.findAll();
		return vehiculos;
	}

	public String crearVehiculo(@RequestBody Vehiculo vehiculo) {
		vehiculoDao.save(vehiculo);
		/*if (celdaService.consultarCeldasDisponibles() <= 30){
			vehiculoDao.save(vehiculo);
			celdaService.agregarUnVehiculoCelda();
			return "Se guardó el vehiculo: " + vehiculo.getPlaca();
		}
		
		return "No hay capacidad";*/
		return "Se registró el vehiculo";
	}

	public String sacarVehiculo(String placa) {
		/*
		}
		Vehiculo vehiculo = vehiculoDao.findByPlaca(placa);
		Date fechaSalida = new Date();
		Date fechaEntrada = vehiculo.getFechaEntrada();
		long diff = fechaSalida.getTime() - fechaEntrada.getTime();
		long diffMinutes = Math.round(diff / (60 * 1000)) + 1;
		long factura = diffMinutes * 100;
		vehiculoDao.delete(vehiculo);
		celdaService.eliminarUnVehiculoCelda();
		return "El valor de la instancia " + factura + " el tiempo transcurrido fue " + diffMinutes + " minutos";
		*/
		Vehiculo vehiculo = vehiculoDao.findByPlaca(placa);
		vehiculoDao.delete(vehiculo);
		return "Se eliminó el vehiculo";
	}
	

}
