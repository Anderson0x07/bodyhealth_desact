package com.bodyhealth.implement;

import com.bodyhealth.model.EntrenadorCliente;
import com.bodyhealth.repository.EntrenadorClienteRepository;
import com.bodyhealth.service.EntrenadorClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntrenadorClienteImplement implements EntrenadorClienteService {
    @Autowired
    private EntrenadorClienteRepository entrenadorClienteRepository;
    @Override
    public List<EntrenadorCliente> listarEntrenadoresClientes() {
        return (List<EntrenadorCliente>) entrenadorClienteRepository.findAll();
    }

    @Override
    public void guardar(EntrenadorCliente entrenadorCliente) {

    }

    @Override
    public void eliminar(EntrenadorCliente entrenadorCliente) {

    }

    @Override
    public EntrenadorCliente encontrarEntrenadorCliente(EntrenadorCliente entrenadorCliente) {
        return null;
    }
}