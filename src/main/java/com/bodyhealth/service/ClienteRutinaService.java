package com.bodyhealth.service;

import com.bodyhealth.model.ClienteRutina;
import com.bodyhealth.model.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteRutinaService {
    public List<ClienteRutina> listarClientesRutina();

    public void guardar(ClienteRutina clienteRutina);

    public void eliminar(ClienteRutina clienteRutina);

    public ClienteRutina encontrarClienteRutina(ClienteRutina clienteRutina);
}
