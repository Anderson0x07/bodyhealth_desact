package com.bodyhealth.implement;

import com.bodyhealth.model.Producto;
import com.bodyhealth.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImplement implements ProductoService {
    @Override
    public List<Producto> listarProductos() {
        return null;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Producto producto) {

    }

    @Override
    public Producto encontrarProducto(Producto producto) {
        return null;
    }
}