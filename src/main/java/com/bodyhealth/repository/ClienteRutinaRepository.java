package com.bodyhealth.repository;

import com.bodyhealth.model.ClienteDetalle;
import com.bodyhealth.model.ClienteRutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRutinaRepository extends JpaRepository<ClienteRutina,Integer> {
    @Query(
            value = "SELECT * FROM cliente_rutina cr where cr.documentoC = :cliente",
            nativeQuery=true
    )
    ClienteRutina encontrarRutina(@Param("cliente") int document);
}
