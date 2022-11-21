package com.bodyhealth.controller;

import com.bodyhealth.model.Usuario;
import com.bodyhealth.repository.UsuarioRepo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private UsuarioRepo rep;
    

//    @GetMapping("/")
//    public String inicio(Model model){
//        var hola="hola";
//        model.addAttribute("hola",hola);
//        return "index";
//    }
    
    @GetMapping("/")
    public String inicio(Model model){
        
        int personas = 1;
        
        log.info("Ejecuntando el controller");
        log.info("usuario login: ");
        
        model.addAttribute("total", personas);
        
        return "index";
    }
    
    @GetMapping("/prueba")
    public String prueba(){
        log.info("ENTRO A PRUEBA");
        
        return "redirect:/";
    }

    @GetMapping("/administradores")
    public String administrador(){
        log.info("ENTRO A ADMINS");
        return "administradores";
    }

    @GetMapping("/trainer/trainer")
    public String trainers(){
        log.info("ENTRO A TRAINER");
        return "/trainer/trainer";
    }

    @GetMapping("/errores/403")
    public String muestraAccesoDenegado(){
        log.info("ENTRO A errores");
        return "/errores/403";
    }
    

}
