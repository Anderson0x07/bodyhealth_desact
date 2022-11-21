package com.bodyhealth.implement;

import com.bodyhealth.model.Proveedor;
import com.bodyhealth.service.ProveedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorImplement implements ProveedorService {
    @Override
    public List<Proveedor> listarProveedores() {
        return null;
    }

    @Override
    public void guardar(Proveedor proveedor) {

    }

    @Override
    public void eliminar(Proveedor proveedor) {

    }

    @Override
    public Proveedor encontrarProveedor(Proveedor proveedor) {
        return null;
    }
}
