package com.bodyhealth.implement;

import com.bodyhealth.model.Pedido;
import com.bodyhealth.repository.PedidoRepository;
import com.bodyhealth.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoImplement implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedidos() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    public void guardar(Pedido pedido) {

    }

    @Override
    public void eliminar(Pedido pedido) {

    }

    @Override
    public Pedido encontrarPedido(Pedido pedido) {
        return null;
    }
}
