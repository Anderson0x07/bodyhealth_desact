package com.bodyhealth.controller;


import com.bodyhealth.model.Administrador;
import com.bodyhealth.model.Cliente;
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

@RestController
@Slf4j
public class AdminController {

    //redirect: Hace peticion a un getMapping

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EntrenadorService entrenadorService;


    //Para acceder al dashboard
    @GetMapping("/admin/dashboard")
    public String inicio(Model model){

        log.info("dashboard");
        model.addAttribute("admin");

        return "/admin/dashboard";
    }

    //Lista clientes en el dashboard del admin
    @GetMapping("/admin/usuarios")
    public List<Cliente> listarClientes(Model model){
        log.info("entró a listar usuarios en admin");
        List<Cliente> clientes = clienteService.listarClientes();

        model.addAttribute("clientes",clientes);

        return clientes;
    }

    //prueba de dash-usuarios
    @GetMapping("/admin/dash-usuarios")
    public String dashUs(){
        return "/admin/dash-usuarios";
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


    //********ENTRENADOR************

    //Lista entrenadores en el dashboard del admin
    @GetMapping("/admin/trainer/trainers")
    public String listarTrainers(Model model){
        List<Entrenador> entrenadores = entrenadorService.listarEntrenadores();

        model.addAttribute("entrenadores",entrenadores);

        return "/admin/trainers/dash-trainers";
    }

    //Guarda clientes en el dashboard del admin
    @PostMapping("/admin/trainer/guardar")
    public String guardarTrainers(Entrenador entrenador){

        entrenadorService.guardar(entrenador);
        return "redirect:/admin/trainer/dash-trainers";
    }

    //Editar clientes en el dashboard del admin
    @GetMapping("/admin/trainer/editar/{documento}")
    public String editarTrainers(Entrenador entrenador, Model model){

        entrenador = entrenadorService.encontrarEntrenador(entrenador);

        model.addAttribute("entrenador",entrenador);

        return "/admin/trainer/editarTrainer";
    }

    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/trainer/eliminar")
    public String eliminarTrainer(Entrenador entrenador){
        entrenadorService.eliminar(entrenador);
        return "redirect:/admin/trainer/dash-trainers";
    }

}
