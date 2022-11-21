package com.bodyhealth.service;


import com.bodyhealth.model.Horario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface HorarioService {
    public List<Horario> listarHorarios();

    public void guardar(Horario horario);

    public void eliminar(Horario horario);

    public Horario encontrarHorario(Horario horario);
}
