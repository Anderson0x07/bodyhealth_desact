package com.bodyhealth.implement;

import com.bodyhealth.model.Horario;
import com.bodyhealth.service.HorarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioImplement implements HorarioService {
    @Override
    public List<Horario> listarHorarios() {
        return null;
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