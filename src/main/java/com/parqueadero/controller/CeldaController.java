package com.parqueadero.controller;

import com.parqueadero.model.Celda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.parqueadero.service.CeldaService;

import java.util.List;


@RestController
@RequestMapping("api/parqueadero/celda")
public class CeldaController {
	
	@Autowired
	private CeldaService celdaService;
	
	@GetMapping("consultar-celda")
	public String consultarCeldasDisponibles(){
		return "La cantidad de celdas disponibles son: " + celdaService.consultarCeldasDisponibles();
	}

	@GetMapping("consultar-todas-celdas")
	public List<Celda> consultarTodasCeldas(){
		return celdaService.consultarTodasCeldas();
	}

	@GetMapping("asignar-celda")
	public String agregarUnVehiculoCelda(@RequestParam String placa){
		return celdaService.agregarUnVehiculoCelda(placa);
	}

	@GetMapping("retirar-vehiculo")
	public String retirarVehiculo(@RequestParam String placa){
		return celdaService.retirarVehiculo(placa);
	}

}
