package com.bodyhealth.repository;

import com.bodyhealth.model.H_EntrenadorCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface H_EntrenadorClienteRepository extends JpaRepository<H_EntrenadorCliente,Integer> {

}
