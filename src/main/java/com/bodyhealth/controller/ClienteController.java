package com.bodyhealth.controller;


import com.bodyhealth.model.Cliente;
import com.bodyhealth.repository.ClienteRepository;
import com.bodyhealth.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ClienteController {
/*
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/admin/usuarios")
    public String listarClientes(Model model){
       List<Cliente> clientes = clienteService.listarClientes();

        model.addAttribute("clientes",clientes);

        return "/admin/usuarios";
    }


    @PostMapping("/admin/guardar")
    public String guardar(Cliente cliente){


        clienteService.guardar(cliente);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/admin/editar/{documento}")
    public String editar(Cliente cliente, Model model){

        cliente = clienteService.encontrarCliente(cliente);

        model.addAttribute("cliente",cliente);

        return "/admin/editarClientes";
    }

    @GetMapping("/admin/eliminar")
    public String eliminar(Cliente cliente){
        clienteService.eliminar(cliente);
        return "redirect:/admin/usuarios";
    } */
}
