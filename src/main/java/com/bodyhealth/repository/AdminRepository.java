package com.bodyhealth.repository;

import com.bodyhealth.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrador,Integer>  {

}
