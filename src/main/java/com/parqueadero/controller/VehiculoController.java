package com.parqueadero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parqueadero.model.Vehiculo;
import com.parqueadero.service.VehiculoService;

@RestController
@RequestMapping("api/vehiculo/")
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping("consultar-placa")
	public Vehiculo obtenerVehiculos(@RequestParam String placa){
		return vehiculoService.consultarPlaca(placa);
	}
	
	@GetMapping("consultar-vehiculos")
	public List<Vehiculo> obtenerVehiculos(){
		return vehiculoService.consultarTodo();
	}
	
	@PostMapping("crear")
	public String crearVehiculo(@RequestBody Vehiculo vehiculo) {
		return vehiculoService.crearVehiculo(vehiculo);
	}
	
	@DeleteMapping("sacar-vehiculo")
	public String sacarVehiculo(@RequestParam String placa) {
		return vehiculoService.sacarVehiculo(placa);
		
	}

}
