package com.bodyhealth.implement;

import com.bodyhealth.model.Rol;
import com.bodyhealth.service.RolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolImplement implements RolService {
    @Override
    public List<Rol> listarRoles() {
        return null;
    }

    @Override
    public void guardar(Rol rol) {

    }

    @Override
    public void eliminar(Rol rol) {

    }

    @Override
    public Rol encontrarRol(Rol rol) {
        return null;
    }
}
