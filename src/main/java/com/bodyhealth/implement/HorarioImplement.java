package com.bodyhealth.implement;

import com.bodyhealth.model.Horario;
import com.bodyhealth.repository.HorarioRepository;
import com.bodyhealth.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioImplement implements HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;
    @Override
    public List<Horario> listarHorarios() {
        return (List<Horario>) horarioRepository.findAll();
    }

    @Override
    public void guardar(Horario horario) {

    }

    @Override
    public void eliminar(Horario horario) {

    }

    @Override
    public Horario encontrarHorario(Horario horario) {
        return null;
    }
}
