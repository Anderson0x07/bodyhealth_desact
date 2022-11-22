package com.bodyhealth.controller;

import com.bodyhealth.model.ClienteRutina;
import com.bodyhealth.model.Rutina;
import com.bodyhealth.service.ClienteRutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clienteR")
public class ClienteRutinaController {
    @Autowired
    private ClienteRutinaService clienteRutinaService;
    @GetMapping("/lista")
    public List<ClienteRutina> listarClienteRutinas(Model model){
        List<ClienteRutina> clientesRutinas = clienteRutinaService.listarClientesRutina();

        model.addAttribute("clientesRutinas",clientesRutinas);

        return clientesRutinas;
    }
}
