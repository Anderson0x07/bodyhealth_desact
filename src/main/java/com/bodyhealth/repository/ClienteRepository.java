package com.bodyhealth.repository;

import com.bodyhealth.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>  {

}
