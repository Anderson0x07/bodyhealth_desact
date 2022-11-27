package com.bodyhealth.controller;


import com.bodyhealth.model.*;
import com.bodyhealth.repository.*;
import com.bodyhealth.service.*;
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
    private ClienteDetalleRepository clienteDetalleRepository;

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private EntrenadorClienteService entrenadorClienteService;
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private EntrenadorService entrenadorService;

    @Autowired
    private ClienteDetalleService clienteDetalleService;

    @Autowired
    private ClienteRutinaRepository clienteRutinaRepository;
    @Autowired
    private RolRepository rolRepository;



    //Lista clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes")
    public String listarClientes(Model model){

        List<Cliente> activos = clienteService.listarActivos();
        List<Cliente> desactivados = clienteService.listarDesactivados();
        model.addAttribute("clientes",activos);
        model.addAttribute("clientesDesactivados",desactivados);
        model.addAttribute("rol",rolRepository.getReferenceById(2));

        return "/admin/clientes/dash-clientes";
    }

    @GetMapping("/admin/dash-clientes/expand/{id_cliente}")
    public String mostrarCliente(Cliente cliente, Model model){

        log.info("CLIENTE QUE LLEGA: "+cliente.toString());

        Cliente cnuevo = clienteService.encontrarCliente(cliente);
        model.addAttribute("cliente",cnuevo);


        if(entrenadorClienteRepository.encontrarEntrenador(cnuevo.getId_cliente())!=null){
            model.addAttribute("entrenadorcliente",entrenadorClienteRepository.encontrarEntrenador(cnuevo.getDocumentoC()));
        }

        if(clienteDetalleRepository.encontrarPlan(cnuevo.getId_cliente())!=null){
            model.addAttribute("clientedetalle",clienteDetalleRepository.encontrarPlan(cnuevo.getDocumentoC()));
        }

        if(clienteRutinaRepository.encontrarRutina(cnuevo.getId_cliente()) != null){
            model.addAttribute("rutinacliente", clienteRutinaRepository.encontrarRutina(cnuevo.getDocumentoC()));
        }



        return "/admin/clientes/cliente-expand";
    }

    //Guarda clientes en el dashboard del admin
    @PostMapping("/admin/dash-clientes/expand/guardar")
    public String guardarCliente(Cliente cliente){

        log.info("LLEGÓ: "+cliente.getDocumentoC());
        clienteService.guardar(cliente);

        return "redirect:/admin/dash-clientes";
    }


    //ACTUALIZA ENTRENADOR A CLIENTE
    @PostMapping("/admin/dash-clientes/expand/guardar-trainer")
    public String cambioEntrenador(EntrenadorCliente entrenadorCliente, Model model){

        log.info("ENTRENADOR ENTRANTE: "+entrenadorCliente.toString());
        EntrenadorCliente copia = entrenadorClienteRepository.encontrarEntrenador(entrenadorCliente.getCliente().getDocumentoC());
        int documentoC = entrenadorCliente.getCliente().getDocumentoC();

        entrenadorCliente.setId_entrenador(entrenadorCliente.getEntrenador().getDocumentoE());
        entrenadorCliente.setId_cliente(entrenadorCliente.getCliente().getDocumentoC());

        entrenadorClienteService.eliminar(copia);
        entrenadorClienteService.guardar(entrenadorCliente);

        model.addAttribute("trainer",entrenadorClienteRepository.encontrarEntrenador(entrenadorCliente.getId_cliente()));


        return "redirect:/admin/dash-clientes/expand/editar/"+documentoC;
    }

    //ACTUALIZA PLAN DEL CLIENTE
    @PostMapping("/admin/dash-clientes/expand/guardar-plan")
    public String cambioPlan(ClienteDetalle clienteDetalle, Model model){

        log.info("LO QUE LLEGA: "+clienteDetalle.toString());
        ClienteDetalle copia = clienteDetalleRepository.encontrarPlan(clienteDetalle.getCliente().getDocumentoC());

        log.info("COPIA: "+copia);
        int documentoC = clienteDetalle.getCliente().getDocumentoC();

        clienteDetalle.setDetalle(clienteDetalle.getDetalle());

        //clienteDetalleService.eliminar(copia);
        clienteDetalleService.guardar(clienteDetalle);


        model.addAttribute("plancliente",clienteDetalleRepository.encontrarPlan(clienteDetalle.getCliente().getDocumentoC()));

        return "redirect:/admin/dash-clientes/expand/editar/"+documentoC;
    }



    //Editar clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/editar/{documentoC}")
    public String editarCliente(Cliente cliente, Model model){
    log.info("entre...");
        cliente = clienteService.encontrarCliente(cliente);

        model.addAttribute("cliente",cliente);
        model.addAttribute("trainer",entrenadorClienteRepository.encontrarEntrenador(cliente.getDocumentoC()));
        model.addAttribute("plancliente", clienteDetalleRepository.encontrarPlan(cliente.getDocumentoC()));
        model.addAttribute("rutinacliente", clienteRutinaRepository.encontrarRutina(cliente.getDocumentoC()));

        //PARA MOSTRAR TODOS LOS ENTRENADORES
        model.addAttribute("trainers",entrenadorService.listarEntrenadores());
        //PARA MOSTRAR TODOS LOS PLANES
        model.addAttribute("planesdetallados",detalleRepository.findAll());
        //PARA MOSTRAR TODOS LOS PLANES
        model.addAttribute("rutinas",clienteRutinaRepository.findAll());


        return "/admin/clientes/cliente-editar";
    }


    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/desactivar/{id_cliente}")
    public String desactivarCliente(Cliente cliente){

        cliente = clienteService.encontrarCliente(cliente);
        log.info(cliente.toString());
        cliente.setEstado(false);

        clienteService.guardar(cliente);


        return "redirect:/admin/dash-clientes";
    }

    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/activar/{id_cliente}")
    public String activarCliente(Cliente cliente){

        cliente = clienteService.encontrarCliente(cliente);

        cliente.setEstado(true);

        clienteService.guardar(cliente);


        return "redirect:/admin/dash-clientes";
    }

}
