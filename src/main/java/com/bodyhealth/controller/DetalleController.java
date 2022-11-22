package com.bodyhealth.controller;

import com.bodyhealth.model.ClienteDetalle;
import com.bodyhealth.model.Detalle;
import com.bodyhealth.service.ClienteDetalleService;
import com.bodyhealth.service.DetalleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle")
public class DetalleController {
    @Autowired
    private DetalleService detalleService;

    @GetMapping("/planesDetallados")
    public List<Detalle> listarPlanesDetallados(Model model){
        List<Detalle> detallePlan = detalleService.listarDetalles();
        model.addAttribute("detallePlan",detallePlan);
        return detallePlan;
    }


    @PostMapping("/detalle/guardar")
    public String guardar(Detalle detalle){


        detalleService.guardar(detalle);
        return "redirect:/clientes/usuarios";
    }

    @GetMapping("/detalle/editar/{documentoC}&{id_detalle}&{fecha_inicio}")
    public String editar(Detalle detalle, Model model){

        detalle = detalleService.encontrarDetalle(detalle);

        model.addAttribute("detalle",detalle);

        return "/detalle/editarClientes";
    }

    @GetMapping("/detalle/eliminar")
    public String eliminar(Detalle detalle){
        detalleService.eliminar(detalle);
        return "redirect:/detalle/clienteDetalle";
    }
}
