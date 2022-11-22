package com.bodyhealth.controller;

import com.bodyhealth.model.Ejercicio;
import com.bodyhealth.model.Entrenador;
import com.bodyhealth.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;
    @GetMapping("/lista")
    public List<Entrenador> listarEjercicios(Model model){
        List<Entrenador> entrenadores = entrenadorService.listarEntrenadores();
        model.addAttribute("entrenadores",entrenadores);
        return entrenadores;
    }
}
