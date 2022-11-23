package com.bodyhealth.controller;

import com.bodyhealth.model.Producto;
import com.bodyhealth.model.Proveedor;
import com.bodyhealth.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @GetMapping("/lista")
    public List<Producto> listarProductos(Model model){
        List<Producto> productos = productoService.listarProductos();

        model.addAttribute("productos",productos);

        return productos;
    }
}
