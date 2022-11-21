package com.bodyhealth.implement;

import com.bodyhealth.model.Musculo;
import com.bodyhealth.service.MusculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusculoImplement implements MusculoService {
    @Override
    public List<Musculo> listarMusculos() {
        return null;
    }

    @Override
    public void guardar(Musculo musculo) {

    }

    @Override
    public void eliminar(Musculo musculo) {

    }

    @Override
    public Musculo encontrarMusculo(Musculo musculo) {
        return null;
    }
}
