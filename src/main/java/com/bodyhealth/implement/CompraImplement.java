package com.bodyhealth.implement;

import com.bodyhealth.model.Compra;
import com.bodyhealth.service.CompraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraImplement implements CompraService {
    @Override
    public List<Compra> listarCompras() {
        return null;
    }

    @Override
    public void guardar(Compra compra) {

    }

    @Override
    public void eliminar(Compra compra) {

    }

    @Override
    public Compra encontrarCompra(Compra compra) {
        return null;
    }
}
