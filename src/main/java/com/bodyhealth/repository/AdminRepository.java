package com.bodyhealth.repository;

import com.bodyhealth.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminRepository extends JpaRepository<Administrador,Integer> , PagingAndSortingRepository<Administrador,Integer> {

}
