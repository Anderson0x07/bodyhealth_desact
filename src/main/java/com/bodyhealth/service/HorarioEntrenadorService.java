package com.bodyhealth.service;

import com.bodyhealth.model.Entrenador;
import com.bodyhealth.model.Horario;
import com.bodyhealth.model.HorarioEntrenador;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HorarioEntrenadorService {

    public void AsignarHorarioEntrenador(HorarioEntrenador horarioEntrenador);

    public void EliminarHorarioEntrenador(HorarioEntrenador horarioEntrenador);


    public List<HorarioEntrenador> BuscarHorarioEntrenador(HorarioEntrenador horarioEntrenador);
}
