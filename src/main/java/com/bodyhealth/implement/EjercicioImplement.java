package com.bodyhealth.implement;

import com.bodyhealth.model.Ejercicio;
import com.bodyhealth.service.EjercicioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioImplement implements EjercicioService {
    @Override
    public List<Ejercicio> listarEjercicios() {
        return null;
    }

    @Override
    public void guardar(Ejercicio ejercicio) {

    }

    @Override
    public void eliminar(Ejercicio ejercicio) {

    }

    @Override
    public Ejercicio encontrarEjercicio(Ejercicio ejercicio) {
        return null;
    }
}
