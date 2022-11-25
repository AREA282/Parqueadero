package com.parqueadero.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="pagos")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    Vehiculo vehiculo;


    @Column(name = "precio")
    private long precio;

    @Column(name = "fecha_liquidacion")
    private Date fechaLiquidacion = new Date();


    @Column(name = "cancelado")
    private boolean cancelado = false;

    public Pago(int id, Vehiculo vehiculo, long precio, Date fechaLiquidacion, boolean cancelado) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.precio = precio;
        this.fechaLiquidacion = fechaLiquidacion;
        this.cancelado = cancelado;
    }

    public Pago() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public Date getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    public void setFechaLiquidacion(Date fechaLiquidacion) {
        this.fechaLiquidacion = fechaLiquidacion;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
}
