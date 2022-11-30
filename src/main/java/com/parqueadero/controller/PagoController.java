package com.parqueadero.controller;



import com.parqueadero.model.Pago;
import com.parqueadero.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/parqueadero/pago")
public class PagoController {


    @Autowired
    private PagoService pagoService;

    @GetMapping("consultar-pagos-pendientes")
    public List<Pago> consultarPagosPendientes(){
        return pagoService.consultarPagosPendientes();
    }


    @GetMapping("consultar-pagos-realizados")
    public List<Pago> consultarPagosRealizados(){
        return pagoService.consultarPagosRealizados();
    }

    @PostMapping("liquidar")
    public Pago liquidar(@RequestParam String placa){
        return pagoService.liquidarVehiculo(placa);
    }

    @PostMapping("pagar")
    public String pagar(@RequestParam Integer id){
        return pagoService.pagarLiquidacion(id);
    }


}
