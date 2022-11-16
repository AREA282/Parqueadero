package com.parqueadero.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="celdas")
public class Celda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	Vehiculo vehiculo;

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	/*@Column(name="cantidadCeldas")
	private int cantidadCeldas;*/
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	/*
	public int getCantidadCeldas() {
		return cantidadCeldas;
	}
	public void setCantidadCeldas(int cantidadCeldas) {
		this.cantidadCeldas = cantidadCeldas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	*/
	
}
