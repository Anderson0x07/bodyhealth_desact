package com.bodyhealth.controller;

import com.bodyhealth.model.Musculo;
import com.bodyhealth.service.MusculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musculo")
public class MusculoController {
    @Autowired
    private MusculoService musculoService;
    @GetMapping("/lista")
    public List<Musculo> listarMusculos(Model model){
        List<Musculo> musculos = musculoService.listarMusculos();

        model.addAttribute("musculos",musculos);

        return musculos;
    }
}
