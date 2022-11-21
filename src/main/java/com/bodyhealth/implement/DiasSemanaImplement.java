package com.bodyhealth.implement;

import com.bodyhealth.model.DiasSemana;
import com.bodyhealth.service.DiasSemanaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiasSemanaImplement implements DiasSemanaService {
    @Override
    public List<DiasSemana> listarDiasSemana() {
        return null;
    }

    @Override
    public void guardar(DiasSemana diasSemana) {

    }

    @Override
    public void eliminar(DiasSemana diasSemana) {

    }

    @Override
    public DiasSemana encontrarDiasSemana(DiasSemana diasSemana) {
        return null;
    }
}
