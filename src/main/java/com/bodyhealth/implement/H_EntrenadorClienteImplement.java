package com.bodyhealth.implement;

import com.bodyhealth.model.*;
import com.bodyhealth.repository.H_EntrenadorClienteRepository;
import com.bodyhealth.service.H_EntrenadorClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class H_EntrenadorClienteImplement implements H_EntrenadorClienteService {

    @Autowired
    private H_EntrenadorClienteRepository h_entrenadorClienteRepository;


    @Override
    public List<H_EntrenadorCliente> listarH_EntrenadorCliente() {
        return (List<H_EntrenadorCliente>) h_entrenadorClienteRepository.findAll();
    }

    @Override
    public void guardar(H_EntrenadorCliente h_entrenadorCliente) {
        h_entrenadorClienteRepository.save(h_entrenadorCliente);
    }

    @Override
    public void eliminar(H_EntrenadorCliente h_entrenadorCliente) {
        h_entrenadorClienteRepository.delete(h_entrenadorCliente);
    }



}
