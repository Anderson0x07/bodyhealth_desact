package com.bodyhealth.controller;

import com.bodyhealth.model.Horario;
import com.bodyhealth.model.Maquina;
import com.bodyhealth.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;
    @GetMapping("/dash-horarios")
    public String listarHorario(Model model){
        List<Horario> horarios = horarioService.listarHorarios();

        model.addAttribute("horarios",horarios);

        return "/admin/dash-horarios";
    }
}
