package com.bodyhealth.implement;

import com.bodyhealth.model.ClienteRutinaEjercicio;
import com.bodyhealth.repository.ClienteRutinaEjercicioRepository;
import com.bodyhealth.service.ClienteRutinaEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteRutinaEjercicioImplement implements ClienteRutinaEjercicioService {
    @Autowired
    private ClienteRutinaEjercicioRepository clienteRutinaEjercicioRepository;
    @Override
    public List<ClienteRutinaEjercicio> listarClientesRutinaEjercicios() {
        return (List<ClienteRutinaEjercicio>) clienteRutinaEjercicioRepository.findAll();
    }

    @Override
    public void guardar(ClienteRutinaEjercicio clienteRutinaEjercicio) {

    }

    @Override
    public void eliminar(ClienteRutinaEjercicio clienteRutinaEjercicio) {

    }

    @Override
    public ClienteRutinaEjercicio encontrarClienteRutinaEjercicio(ClienteRutinaEjercicio clienteRutinaEjercicio) {
        return null;
    }
}
