package com.bodyhealth.controller;


import com.bodyhealth.model.Cliente;
import com.bodyhealth.model.EntrenadorCliente;
import com.bodyhealth.model.Rol;
import com.bodyhealth.repository.ClienteRepository;
import com.bodyhealth.repository.EntrenadorClienteRepository;
import com.bodyhealth.service.ClienteService;
import com.bodyhealth.service.EntrenadorClienteService;
import com.bodyhealth.service.RolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EntrenadorClienteRepository entrenadorClienteRepository;
    @Autowired
    private RolService rolService;


    //Lista clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes")
    public String listarClientes(Model model){

        List<Cliente> activos = clienteService.listarActivos();
        List<Cliente> desactivados = clienteService.listarDesactivados();
        model.addAttribute("clientes",activos);
        model.addAttribute("clientesDesactivados",desactivados);

        return "/admin/clientes/dash-clientes";
    }

    @GetMapping("/admin/dash-clientes/expand/{documentoC}")
    public String mostrarCliente(Cliente cliente, Model model){


        cliente = clienteService.encontrarCliente(cliente);


        model.addAttribute("cliente",cliente);
        model.addAttribute("entrenadorcliente",entrenadorClienteRepository.encontrarClientes(cliente.getDocumentoC()));

        return "/admin/clientes/cliente-expand";
    }

    //Guarda clientes en el dashboard del admin
    @PostMapping("/admin/dash-clientes/expand/guardar")
    public String guardarCliente(Cliente cliente){

        clienteService.guardar(cliente);
        return "redirect:/admin/dash-clientes/expand/"+cliente.getDocumentoC();
    }

    //Editar clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/editar/{documentoC}")
    public String editarCliente(Cliente cliente, Model model){

        cliente = clienteService.encontrarCliente(cliente);

        model.addAttribute("cliente",cliente);
        model.addAttribute("roles",rolService.listarRoles());

        return "/admin/clientes/cliente-editar";
    }


    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/desactivar/{documentoC}")
    public String desactivarCliente(Cliente cliente){

        cliente = clienteService.encontrarCliente(cliente);

        cliente.setEstado(false);

        clienteService.guardar(cliente);


        return "redirect:/admin/dash-clientes";
    }

    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/activar/{documentoC}")
    public String activarCliente(Cliente cliente){

        cliente = clienteService.encontrarCliente(cliente);

        cliente.setEstado(true);

        clienteService.guardar(cliente);


        return "redirect:/admin/dash-clientes";
    }


}
