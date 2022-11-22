package com.bodyhealth.controller;

import com.bodyhealth.model.H_EntrenadorCliente;
import com.bodyhealth.model.Horario;
import com.bodyhealth.service.H_EntrenadorClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hEntrenadorC")
public class H_EntrenadorClienteController {
    @Autowired
    private H_EntrenadorClienteService h_entrenadorClienteService;
    @GetMapping("/lista")
    public List<H_EntrenadorCliente> listarRutinas(Model model){
        List<H_EntrenadorCliente> h_entrenadorClientes = h_entrenadorClienteService.listarH_EntrenadorCliente();

        model.addAttribute("h_entrenadorClientes",h_entrenadorClientes);

        return h_entrenadorClientes;
    }
}
