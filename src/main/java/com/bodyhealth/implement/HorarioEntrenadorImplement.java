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
    public List<HorarioEntrenador> listarHorariosEntrenador() {
        return (List<HorarioEntrenador>) horarioEntrenadorRepository.findAll();
    }

    @Override
    public void guardar(HorarioEntrenador horarioEntrenador) {

    }

    @Override
    public void eliminar(HorarioEntrenador horarioEntrenador) {

    }

    @Override
    public HorarioEntrenador encontrarHorarioEntrenador(HorarioEntrenador horarioEntrenador) {
        return null;
    }
}
