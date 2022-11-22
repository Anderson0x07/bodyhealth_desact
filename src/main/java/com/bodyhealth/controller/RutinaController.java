package com.bodyhealth.controller;

import com.bodyhealth.model.Ejercicio;
import com.bodyhealth.model.Musculo;
import com.bodyhealth.model.Rutina;
import com.bodyhealth.model.RutinaEjercicio;
import com.bodyhealth.service.EjercicioService;
import com.bodyhealth.service.MusculoService;
import com.bodyhealth.service.RutinaEjercicioService;
import com.bodyhealth.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RutinaController {
    @Autowired
    private RutinaService rutinaService;
    @Autowired
    private RutinaEjercicioService rutinaEjercicioService;
    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/dash-rutinas")
    public String listarRutinas(Model model){
        List<Rutina> rutinas = rutinaService.listarRutina();

        model.addAttribute("rutinas",rutinas);
        model.addAttribute("rutina_ejercicios",listarRutinaEjercicio());
        model.addAttribute("ejercicios",listarEjercicios());

        return "/admin/dash-rutinas";
    }

    public List<RutinaEjercicio> listarRutinaEjercicio(){
        return rutinaEjercicioService.listarRutinasEjercicios();
    }

    public List<Ejercicio> listarEjercicios(){
        return ejercicioService.listarEjercicios();
    }
}
