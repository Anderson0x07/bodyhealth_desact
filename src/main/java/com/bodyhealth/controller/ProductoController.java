package com.bodyhealth.controller;

import com.bodyhealth.model.Maquina;
import com.bodyhealth.model.Producto;
import com.bodyhealth.model.Proveedor;
import com.bodyhealth.service.MaquinaService;
import com.bodyhealth.service.ProductoService;
import com.bodyhealth.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/dash-productos")
    public String listarProductos(Model model){
        List<Producto> productos = productoService.listarProductos();

        model.addAttribute("productos",productos);
        model.addAttribute("proveedores",proveedorService.listarProveedores());

        return "/admin/productos/dash-productos";
    }

    //Guarda nuevo producto
    @PostMapping("/dash-productos/guardar")
    public String guardarNuevoProducto(Producto producto){

        productoService.guardar(producto);

        return "redirect:/admin/dash-productos";
    }

    @GetMapping("/dash-productos/expand/{id_producto}")
    public String expandProducto(Producto producto, Model model){

        producto = productoService.encontrarProducto(producto);

        model.addAttribute("producto",producto);

        return "/admin/productos/producto-expand";
    }

    //Guarda edición de producto en el dashboard del admin
    @PostMapping("/dash-productos/expand/guardar")
    public String guardarEdicionProducto(Producto producto){

        productoService.guardar(producto);

        return "redirect:/admin/dash-productos/expand/"+producto.getId_producto();
    }


    @GetMapping("/dash-productos/expand/editar/{id_producto}")
    public String editar(Producto producto, Model model){

        producto = productoService.encontrarProducto(producto);

        model.addAttribute("producto",producto);
        model.addAttribute("proveedores",proveedorService.listarProveedores());


        return "/admin/productos/producto-editar";
    }

    @GetMapping("/dash-productos/eliminar")
    public String eliminarProducto(Producto producto){
        productoService.eliminar(producto);
        return "redirect:/admin/dash-productos";
    }
}
