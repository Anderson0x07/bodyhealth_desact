package com.bodyhealth.controller;

import com.bodyhealth.model.Cliente;
import com.bodyhealth.model.Entrenador;
import com.bodyhealth.model.Producto;
import com.bodyhealth.model.Proveedor;
import com.bodyhealth.service.AdminService;
import com.bodyhealth.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;
    @Autowired
    private AdminService adminService;
    @GetMapping("/dash-trainers")
    public String listarTrainers(Model model){

        List<Entrenador> activos = entrenadorService.listarActivos();
        List<Entrenador> desactivados = entrenadorService.listarDesactivados();
        model.addAttribute("trainers",activos);
        model.addAttribute("trainersDesactivados",desactivados);
        model.addAttribute("admins",adminService.listarAdministradores());

        return "/admin/trainers/dash-trainers";
    }

    @GetMapping("/dash-trainers/expand/{id_entrenador}")
    public String mostrarEntrenador(Entrenador entrenador, Model model){


        Entrenador trainer = entrenadorService.encontrarEntrenador(entrenador);
        model.addAttribute("trainer",trainer);


        return "/admin/trainers/trainer-expand";
    }

    @GetMapping("/dash-trainers/expand/editar/{id_entrenador}")
    public String editar(Entrenador entrenador, Model model){

        entrenador = entrenadorService.encontrarEntrenador(entrenador);

        model.addAttribute("trainer",entrenador);


        return "/admin/trainers/trainer-editar";
    }

    //Guarda edición de entrenador en el dashboard del admin
    @PostMapping("/dash-trainers/expand/guardar")
    public String guardarEdicionEntrenador(Entrenador entrenador){

        entrenadorService.guardar(entrenador);

        return "redirect:/admin/dash-trainers/expand/"+entrenador.getId_entrenador();
    }

    //Desactiva entrenadores en el dashboard del admin
    @GetMapping("/dash-trainers/expand/desactivar/{id_entrenador}")
    public String desactivarEntrenador(Entrenador entrenador){

        entrenador = entrenadorService.encontrarEntrenador(entrenador);

        entrenador.setEstado(false);

        entrenadorService.guardar(entrenador);


        return "redirect:/admin/dash-trainers";
    }

    //Desactiva entrenadores en el dashboard del admin
    @GetMapping("/dash-trainers/expand/activar/{id_entrenador}")
    public String activarEntrenador(Entrenador entrenador){

        entrenador = entrenadorService.encontrarEntrenador(entrenador);

        entrenador.setEstado(true);

        entrenadorService.guardar(entrenador);


        return "redirect:/admin/dash-trainers";
    }
}
