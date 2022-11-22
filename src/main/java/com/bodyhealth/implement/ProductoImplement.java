package com.bodyhealth.implement;

import com.bodyhealth.model.Producto;
import com.bodyhealth.repository.ProductoRepository;
import com.bodyhealth.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImplement implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoRepository.findAll();
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
