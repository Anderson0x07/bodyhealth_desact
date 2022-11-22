package com.bodyhealth.implement;

import com.bodyhealth.model.ControlCliente;
import com.bodyhealth.repository.ControlClienteRepository;
import com.bodyhealth.service.ControlClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlClienteImplement implements ControlClienteService {
    @Autowired
    private ControlClienteRepository controlClienteRepository;
    @Override
    public List<ControlCliente> listarContolClientes() {
        return (List<ControlCliente>) controlClienteRepository.findAll();
    }

    @Override
    public void guardar(ControlCliente controlCliente) {

    }

    @Override
    public void eliminar(ControlCliente controlCliente) {

    }

    @Override
    public ControlCliente encontrarControlCliente(ControlCliente controlCliente) {
        return null;
    }
}
