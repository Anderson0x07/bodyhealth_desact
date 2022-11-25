package com.bodyhealth.controller;


import com.bodyhealth.model.Administrador;
import com.bodyhealth.model.Cliente;
import com.bodyhealth.service.AdminService;
import com.bodyhealth.service.ClienteService;
import com.bodyhealth.service.EntrenadorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class AdminController {

    //redirect: Hace peticion a un getMapping

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/admin/lista")
    public List<Administrador> listarRutinas(Model model){
        List<Administrador> administradores = adminService.listarAdministradores();

        model.addAttribute("administradores",administradores);

        return administradores;
    }
    //Para acceder al dashboard
    @GetMapping("/admin/dashboard")
    public String inicio(Model model){

        log.info("dashboard");
        model.addAttribute("admin");

        return "/admin/dashboard";
    }

    @GetMapping("/admin/dash-horarios")
    public String listarHorarios(){
        return "/admin/dash-horarios";
    }




}
