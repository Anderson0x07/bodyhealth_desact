package com.bodyhealth.implement;

import com.bodyhealth.model.Cliente;
import com.bodyhealth.model.ClienteDetalle;
import com.bodyhealth.repository.ClienteDetalleRepository;
import com.bodyhealth.service.ClienteDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteDetalleImplement implements ClienteDetalleService {
    @Autowired
    private ClienteDetalleRepository clienteDetalleRepository;
    @Override
    public List<ClienteDetalle> listarClientesDetalles() {
        return (List<ClienteDetalle>) clienteDetalleRepository.findAll();
    }
  
    @Override
    public void guardar(ClienteDetalle clienteDetalle) {

    }

    @Override
    public void eliminar(ClienteDetalle clienteDetalle) {

    }

    @Override
    public ClienteDetalle encontrarClienteDetalle(ClienteDetalle clienteDetalle) {
        return null;
    }
}
