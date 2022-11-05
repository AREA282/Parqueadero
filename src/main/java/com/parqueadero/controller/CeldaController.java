package com.parqueadero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parqueadero.service.CeldaService;


@RestController
@RequestMapping("api/parqueadero/celda")
public class CeldaController {
	
	@Autowired
	private CeldaService celdaService;
	
	@GetMapping("consultar-celda")
	public String obtenerCeldasDisponibles(){
		return "La cantidad de celdas disponibles son: " + celdaService.consultarCeldasDisponibles();
	}

}
