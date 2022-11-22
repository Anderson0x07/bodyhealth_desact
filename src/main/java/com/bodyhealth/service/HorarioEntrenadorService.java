package com.bodyhealth.service;

import com.bodyhealth.model.Entrenador;
import com.bodyhealth.model.Horario;
import com.bodyhealth.model.HorarioEntrenador;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HorarioEntrenadorService {

    public List<HorarioEntrenador> listarHorariosEntrenador();

    public void guardar(HorarioEntrenador horarioEntrenador);

    public void eliminar(HorarioEntrenador horarioEntrenador);

    public HorarioEntrenador encontrarHorarioEntrenador(HorarioEntrenador horarioEntrenador);
}
