package com.bodyhealth.implement;

import com.bodyhealth.model.Entrenador;
import com.bodyhealth.model.Horario;
import com.bodyhealth.model.HorarioEntrenador;
import com.bodyhealth.repository.HorarioEntrenadorRepository;
import com.bodyhealth.service.HorarioEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioEntrenadorImplement implements HorarioEntrenadorService {

    @Autowired
    private HorarioEntrenadorRepository horarioEntrenadorRepository;


    @Override
    public void AsignarHorarioEntrenador(HorarioEntrenador horarioEntrenador) {
        horarioEntrenadorRepository.save(horarioEntrenador);
    }

    @Override
    public void EliminarHorarioEntrenador(HorarioEntrenador horarioEntrenador) {
        horarioEntrenadorRepository.delete(horarioEntrenador);
    }

    @Override
    public List<HorarioEntrenador> BuscarHorarioEntrenador(HorarioEntrenador horarioEntrenador) {
        return horarioEntrenadorRepository.findAll();
    }
}
