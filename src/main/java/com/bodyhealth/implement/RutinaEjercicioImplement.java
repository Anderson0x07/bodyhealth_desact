package com.bodyhealth.implement;

import com.bodyhealth.model.RutinaEjercicio;
import com.bodyhealth.repository.RutinaEjercicioRepository;
import com.bodyhealth.service.RutinaEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaEjercicioImplement implements RutinaEjercicioService {
    @Autowired
    private RutinaEjercicioRepository rutinaEjercicioRepository;
    @Override
    public List<RutinaEjercicio> listarRutinasEjercicios() {
        return (List<RutinaEjercicio>) rutinaEjercicioRepository.findAll();
    }

    @Override
    public void guardar(RutinaEjercicio rutinaEjercicio) {

    }

    @Override
    public void eliminar(RutinaEjercicio rutinaEjercicio) {

    }

    @Override
    public RutinaEjercicio encontrarRutinaEjercicio(RutinaEjercicio rutinaEjercicio) {
        return null;
    }
}
