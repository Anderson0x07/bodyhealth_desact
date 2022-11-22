package com.bodyhealth.controller;

import com.bodyhealth.model.HorarioEntrenador;
import com.bodyhealth.model.Maquina;
import com.bodyhealth.service.HorarioEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarioE")
public class HorarioEntrenadorController {
    @Autowired
    private HorarioEntrenadorService horarioEntrenadorService;
    @GetMapping("/lista")
    public List<HorarioEntrenador> listarRutinas(Model model){
        List<HorarioEntrenador> horarioEntrenadores = horarioEntrenadorService.listarHorariosEntrenador();

        model.addAttribute("horarioEntrenadores",horarioEntrenadores);

        return horarioEntrenadores;
    }
}
