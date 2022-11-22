package com.bodyhealth.implement;

import com.bodyhealth.model.Rutina;
import com.bodyhealth.repository.RutinaRepository;
import com.bodyhealth.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RutinaImplement implements RutinaService {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Override
    public List<Rutina> listarRutina() {
        return (List<Rutina>) rutinaRepository.findAll();
    }

    @Override
    public void guardar(Rutina rutina) {

    }

    @Override
    public void eliminar(Rutina rutina) {

    }

    @Override
    public Rutina encontrarRutina(Rutina rutina) {
        return null;
    }
}
