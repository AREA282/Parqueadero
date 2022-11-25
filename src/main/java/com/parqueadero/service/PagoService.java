package com.parqueadero.service;


import com.parqueadero.model.Pago;
import com.parqueadero.model.Vehiculo;
import com.parqueadero.repository.PagoDao;
import com.parqueadero.repository.VehiculoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

import java.util.concurrent.TimeUnit;

@Service
public class PagoService {

    @Autowired
    private PagoDao pagoDao;

    @Autowired
    private VehiculoDao vehiculoDao;


    public List<Pago> consultarPagosPendientes() {
        List<Pago> pagos = pagoDao.findbyPendiente();
        return pagos;
    }

    public List<Pago> consultarPagosRealizados() {
        List<Pago> pagos = pagoDao.findbyCancelado();
        return pagos;
    }

    public List<Pago> consultarPagosPlaca(@RequestParam String placa) {
        Vehiculo vehiculo = vehiculoDao.findByPlaca(placa);

        List<Pago> pagos = pagoDao.findbyPlaca(vehiculo.getPlaca());
        return pagos;
    }

    public Pago liquidarVehiculo(@RequestParam String placa) {
        Vehiculo vehiculo = vehiculoDao.findByPlaca(placa);
        Date dateBefore  = vehiculo.getFechaPago();
        Date dateAfter  = new Date();

        long dateBeforeInMs = dateBefore.getTime();
        long dateAfterInMs = dateAfter.getTime();
        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

        Pago pago = new Pago();
        pago.setPrecio(2000*daysDiff);
        pago.setVehiculo(vehiculo);
        pagoDao.save(pago);

        return pago;
    }

    public String pagarLiquidacion(@RequestParam int id) {
        Pago pago = pagoDao.findByIdNew(id);
        pago.setCancelado(true);

        pagoDao.save(pago);

        return "Se realizó el pago";
    }

}
