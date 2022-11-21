package com.bodyhealth.implement;

import com.bodyhealth.model.ControlCliente;
import com.bodyhealth.service.ControlClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlClienteImplement implements ControlClienteService {
    @Override
    public List<ControlCliente> listarContolClientes() {
        return null;
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
