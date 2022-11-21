package com.bodyhealth.implement;

import com.bodyhealth.model.Maquina;
import com.bodyhealth.service.MaquinaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinaImplement implements MaquinaService {
    @Override
    public List<Maquina> listarMaquinas() {
        return null;
    }

    @Override
    public void guardar(Maquina maquina) {

    }

    @Override
    public void eliminar(Maquina maquina) {

    }

    @Override
    public Maquina encontrarMaquina(Maquina maquina) {
        return null;
    }
}
