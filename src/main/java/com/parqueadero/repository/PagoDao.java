package com.parqueadero.repository;


import com.parqueadero.model.Celda;
import com.parqueadero.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoDao extends JpaRepository<Pago, Integer> {


    @Query(nativeQuery = true, value = "select * from pagos where vehiculo_id= :vehiculo_id")
    List<Pago> findbyPlaca(String vehiculo_id);

    @Query(nativeQuery = true, value = "select * from pagos where cancelado= 1")
    List<Pago> findbyCancelado();

    @Query(nativeQuery = true, value = "select * from pagos where cancelado= 0")
    List<Pago> findbyPendiente();



    @Query(nativeQuery = true, value = "select * from pagos where id= :id")
    Pago findByIdNew(Integer id);
}
