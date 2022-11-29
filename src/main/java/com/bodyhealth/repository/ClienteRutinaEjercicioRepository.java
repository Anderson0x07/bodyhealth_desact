package com.bodyhealth.repository;

import com.bodyhealth.model.ClienteRutinaEjercicio;
import com.bodyhealth.model.ControlCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRutinaEjercicioRepository extends JpaRepository<ClienteRutinaEjercicio,Integer> {

    /*@Query(
            value = "SELECT * from cliente_rutina_ejercicio c where c.id_cliente = :id_cliente ORDER BY c.id_cliente DESC limit 1",
            nativeQuery = true
    )
    ClienteRutinaEjercicio encontrarRutinaCliente(@Param("id_cliente") int id_cliente);*/
}
