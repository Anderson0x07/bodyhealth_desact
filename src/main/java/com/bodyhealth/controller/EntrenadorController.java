package com.bodyhealth.controller;

import com.bodyhealth.model.Ejercicio;
import com.bodyhealth.model.Entrenador;
import com.bodyhealth.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;
    @GetMapping("/dash-trainers")
    public String listarTrainers(Model model){
        List<Entrenador> trainers = entrenadorService.listarEntrenadores();
        model.addAttribute("trainers",trainers);
        return "/admin/dash-trainers";
    }
}
