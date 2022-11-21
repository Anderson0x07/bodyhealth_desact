package com.bodyhealth.repository;


import com.bodyhealth.model.Horario;
import com.bodyhealth.model.HorarioEntrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioEntrenadorRepository extends JpaRepository<HorarioEntrenador,Integer> {
}
