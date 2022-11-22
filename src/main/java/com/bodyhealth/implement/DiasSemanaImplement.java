package com.bodyhealth.implement;

import com.bodyhealth.model.DiasSemana;
import com.bodyhealth.repository.DiasSemanaRepository;
import com.bodyhealth.service.DiasSemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiasSemanaImplement implements DiasSemanaService {
    @Autowired
    private DiasSemanaRepository diasSemanaRepository;
    @Override
    public List<DiasSemana> listarDiasSemana() {
        return (List<DiasSemana>) diasSemanaRepository.findAll();
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
