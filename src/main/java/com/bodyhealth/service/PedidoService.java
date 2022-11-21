package com.bodyhealth.service;

import com.bodyhealth.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public interface PedidoService{
    public void agregarPedido(Pedido pedido);
}
