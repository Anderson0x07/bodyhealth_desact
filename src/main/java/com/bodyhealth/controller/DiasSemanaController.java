package com.bodyhealth.controller;

import com.bodyhealth.model.Detalle;
import com.bodyhealth.model.DiasSemana;
import com.bodyhealth.service.DiasSemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diaSemana")
public class DiasSemanaController {
    @Autowired
    private DiasSemanaService diasSemanaService;
    @GetMapping("/lista")
    public List<DiasSemana> listarPlanesDetallados(Model model){
        List<DiasSemana> diasSemanas = diasSemanaService.listarDiasSemana();
        model.addAttribute("diasSemanas",diasSemanas);
        return diasSemanas;
    }
}
