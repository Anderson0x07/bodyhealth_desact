package com.bodyhealth.controller;

import com.bodyhealth.model.Maquina;
import com.bodyhealth.model.Proveedor;
import com.bodyhealth.service.MaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MaquinaController {
    @Autowired
    private MaquinaService maquinaService;
    @GetMapping("/dash-maquinas")
    public String listarMaquinas(Model model){
        List<Maquina> maquinas = maquinaService.listarMaquinas();

        model.addAttribute("maquinas",maquinas);

        return "/admin/dash-maquinas";
    }
}
