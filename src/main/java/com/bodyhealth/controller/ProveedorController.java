package com.bodyhealth.controller;

import com.bodyhealth.model.Proveedor;
import com.bodyhealth.model.Rutina;
import com.bodyhealth.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;
    @GetMapping("/lista")
    public List<Proveedor> listarRutinas(Model model){
        List<Proveedor> proveedores = proveedorService.listarProveedores();

        model.addAttribute("proveedores",proveedores);

        return proveedores;
    }
}
