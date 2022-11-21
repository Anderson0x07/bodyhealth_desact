package com.bodyhealth.service;

import com.bodyhealth.model.DiasSemana;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DiasSemanaService{
    public List<DiasSemana> listarDiasSemana();

    public void guardar(DiasSemana diasSemana);

    public void eliminar(DiasSemana diasSemana);

    public DiasSemana encontrarDiasSemana(DiasSemana diasSemana);
}
