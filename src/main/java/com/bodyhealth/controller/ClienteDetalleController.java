package com.bodyhealth.controller;

import com.bodyhealth.model.ClienteDetalle;
import com.bodyhealth.service.ClienteDetalleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ClienteDetalleController {

    @Autowired
    private ClienteDetalleService clienteDetalleService;

    @GetMapping("/clientes/clienteDetalle")
    public List<ClienteDetalle> listarClientes(Model model){
        List<ClienteDetalle> clientesDetalle = clienteDetalleService.listarClientesDetalles();
        log.info(""+clientesDetalle.size());
        log.info("entró a listar");
        model.addAttribute("clientesDetalle",clientesDetalle);
        log.info("Pasó");
        return clientesDetalle;
    }


    @PostMapping("/clientes/guardar")
    public String guardar(ClienteDetalle clienteDetalle){


        clienteDetalleService.guardar(clienteDetalle);
        return "redirect:/clientes/usuarios";
    }

    @GetMapping("/clientes/editar/{documentoC}&{id_detalle}&{fecha_inicio}")
    public String editar(ClienteDetalle clienteDetalle, Model model){

        clienteDetalle = clienteDetalleService.encontrarClienteDetalle(clienteDetalle);

        model.addAttribute("clienteDetalle",clienteDetalle);

        return "/clientes/editarClientes";
    }

    @GetMapping("/clientes/eliminar")
    public String eliminar(ClienteDetalle clienteDetalle){
        clienteDetalleService.eliminar(clienteDetalle);
        return "redirect:/clientes/clienteDetalle";
    }
}
