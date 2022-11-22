package com.bodyhealth.controller;

import com.bodyhealth.model.Pedido;
import com.bodyhealth.model.Producto;
import com.bodyhealth.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping("/lista")
    public List<Pedido> listarRutinas(Model model){
        List<Pedido> pedidos = pedidoService.listarPedidos();

        model.addAttribute("pedidos",pedidos);

        return pedidos;
    }
}
