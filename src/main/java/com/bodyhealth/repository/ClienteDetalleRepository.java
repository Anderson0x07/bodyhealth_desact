package com.bodyhealth.repository;

import com.bodyhealth.model.ClienteDetalle;
import com.bodyhealth.model.EntrenadorCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteDetalleRepository extends JpaRepository<ClienteDetalle,Integer> {
    @Query(
            value = "SELECT * from cliente_detalle cd where cd.documentoC = :cliente",
            nativeQuery=true
    )
    ClienteDetalle encontrarPlan(@Param("cliente") int document);
}
