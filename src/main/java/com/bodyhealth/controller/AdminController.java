package com.bodyhealth.controller;


import com.bodyhealth.model.Administrador;
import com.bodyhealth.model.Cliente;
import com.bodyhealth.model.Compra;
import com.bodyhealth.model.Entrenador;
import com.bodyhealth.service.AdminService;
import com.bodyhealth.service.ClienteService;
import com.bodyhealth.service.EntrenadorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Slf4j
public class AdminController {

    //redirect: Hace peticion a un getMapping

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/admin/lista")
    public List<Administrador> listarRutinas(Model model){
        List<Administrador> administradores = adminService.listarAdministradores();

        model.addAttribute("administradores",administradores);

        return administradores;
    }
    //Para acceder al dashboard
    @GetMapping("/admin/dashboard")
    public String inicio(Model model){

        log.info("dashboard");
        model.addAttribute("admin");

        return "/admin/dashboard";
    }

    //Lista clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes")
    public String listarClientes(Model model){
        log.info("entró a listar usuarios en admin");
        List<Cliente> clientes = clienteService.listarClientes();

        model.addAttribute("clientes",clientes);

        return "/admin/dash-clientes";
    }


    //Guarda clientes en el dashboard del admin
    @PostMapping("/admin/guardar")
    public String guardarCliente(Cliente cliente){

        clienteService.guardar(cliente);
        return "redirect:/admin/usuarios";
    }

    //Editar clientes en el dashboard del admin
    @GetMapping("/admin/editar/{documento}")
    public String editarCliente(Cliente cliente, Model model){

        cliente = clienteService.encontrarCliente(cliente);

        model.addAttribute("cliente",cliente);

        return "/admin/editarClientes";
    }

    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/eliminar")
    public String eliminarCliente(Cliente cliente){
        clienteService.eliminar(cliente);
        return "redirect:/admin/usuarios";
    }




}
