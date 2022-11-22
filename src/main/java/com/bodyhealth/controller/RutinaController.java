package com.bodyhealth.controller;

import com.bodyhealth.model.Musculo;
import com.bodyhealth.model.Rutina;
import com.bodyhealth.service.MusculoService;
import com.bodyhealth.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rutina")
public class RutinaController {
    @Autowired
    private RutinaService rutinaService;
    @GetMapping("/lista")
    public List<Rutina> listarRutinas(Model model){
        List<Rutina> rutinas = rutinaService.listarRutina();

        model.addAttribute("rutinas",rutinas);

        return rutinas;
    }
}
