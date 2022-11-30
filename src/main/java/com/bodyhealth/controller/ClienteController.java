package com.bodyhealth.controller;


import com.bodyhealth.model.*;
import com.bodyhealth.repository.*;
import com.bodyhealth.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EntrenadorClienteRepository entrenadorClienteRepository;
    @Autowired
    private ClienteDetalleRepository clienteDetalleRepository;

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private EntrenadorClienteService entrenadorClienteService;
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private EntrenadorService entrenadorService;

    @Autowired
    private ClienteDetalleService clienteDetalleService;

    @Autowired
    private RolRepository rolRepository;
    @Autowired
    ProductoService productoService;



    //Lista clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes")
    public String listarClientes(Model model){

        List<Cliente> activos = clienteService.listarActivos();
        List<Cliente> desactivados = clienteService.listarDesactivados();
        model.addAttribute("clientes",activos);
        model.addAttribute("clientesDesactivados",desactivados);
        model.addAttribute("rol",rolRepository.getReferenceById(2));

        return "/admin/clientes/dash-clientes";
    }

    @GetMapping("/admin/dash-clientes/expand/{id_cliente}")
    public String mostrarCliente(Cliente cliente, Model model){

        log.info("CLIENTE QUE LLEGA: "+cliente.toString());

        Cliente cnuevo = clienteService.encontrarCliente(cliente);
        model.addAttribute("cliente",cnuevo);


        /*if(entrenadorClienteRepository.encontrarEntrenador(cnuevo.getId_cliente())!=null){
            model.addAttribute("entrenadorcliente",entrenadorClienteRepository.encontrarEntrenador(cnuevo.getDocumentoC()));
        }

        if(clienteDetalleRepository.encontrarPlan(cnuevo.getId_cliente())!=null){
            model.addAttribute("clientedetalle",clienteDetalleRepository.encontrarPlan(cnuevo.getDocumentoC()));
        }*/




        return "/admin/clientes/cliente-expand";
    }

    //Guarda clientes en el dashboard del admin
    @PostMapping("/admin/dash-clientes/expand/guardar")
    public String guardarCliente(Cliente cliente,@RequestParam("file") MultipartFile imagen){
        Path directorioImagenes = Paths.get("src//main//resources//static/images");
        String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
        try {
            byte[] bytesImg = imagen.getBytes();
            Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
            Files.write(rutaCompleta, bytesImg);
            cliente.setFoto(imagen.getOriginalFilename());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("LLEGÓ: "+cliente.getDocumentoC());
        clienteService.guardar(cliente);

        return "redirect:/admin/dash-clientes";
    }


    //ACTUALIZA ENTRENADOR A CLIENTE
    @PostMapping("/admin/dash-clientes/expand/guardartrainer")
    public String cambioEntrenador(EntrenadorCliente entrenadorCliente, Model model){

        int id_cliente = entrenadorCliente.getCliente().getId_cliente();

        entrenadorClienteService.guardar(entrenadorCliente);

        model.addAttribute("trainer",entrenadorClienteRepository.encontrarEntrenador(entrenadorCliente.getCliente().getId_cliente()));

        return "redirect:/admin/dash-clientes/expand/editar/"+id_cliente;
    }

    //ACTUALIZA PLAN DEL CLIENTE
    @PostMapping("/admin/dash-clientes/expand/guardar-plan")
    public String cambioPlan(ClienteDetalle clienteDetalle, Model model){

        log.info("LO QUE LLEGA: "+clienteDetalle.toString());
        ClienteDetalle copia = clienteDetalleRepository.encontrarPlan(clienteDetalle.getCliente().getDocumentoC());

        log.info("COPIA: "+copia);
        int documentoC = clienteDetalle.getCliente().getDocumentoC();

        clienteDetalle.setDetalle(clienteDetalle.getDetalle());

        //clienteDetalleService.eliminar(copia);
        clienteDetalleService.guardar(clienteDetalle);


        model.addAttribute("plancliente",clienteDetalleRepository.encontrarPlan(clienteDetalle.getCliente().getDocumentoC()));

        return "redirect:/admin/dash-clientes/expand/editar/"+documentoC;
    }



    //Editar clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/editar/{id_cliente}")
    public String editarCliente(Cliente cliente, Model model){
    log.info("entre...");
        cliente = clienteService.encontrarCliente(cliente);
        model.addAttribute("cliente",cliente);

        EntrenadorCliente entrenadorCliente = entrenadorClienteRepository.encontrarEntrenador(cliente.getId_cliente());

        if(entrenadorCliente!=null){
            model.addAttribute("trainer",entrenadorCliente);
        }
        //model.addAttribute("plancliente", clienteDetalleRepository.encontrarPlan(cliente.getId_cliente()));

        //PARA MOSTRAR TODOS LOS ENTRENADORES POR JORNADA
        List<Entrenador> entrenadoresJornada = entrenadorRepository.entrenadoresJornada(cliente.getJornada());
        if(entrenadoresJornada.size()>0){
            model.addAttribute("trainers",entrenadoresJornada);
        }

        //PARA MOSTRAR TODOS LOS PLANES
        //model.addAttribute("planesdetallados",detalleRepository.findAll());


        return "/admin/clientes/cliente-editar";
    }
    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/desactivar/{id_cliente}")
    public String desactivarCliente(Cliente cliente){

        cliente = clienteService.encontrarCliente(cliente);
        log.info(cliente.toString());
        cliente.setEstado(false);

        clienteService.guardar(cliente);


        return "redirect:/admin/dash-clientes";
    }
    //Desactiva clientes en el dashboard del admin
    @GetMapping("/admin/dash-clientes/expand/activar/{id_cliente}")
    public String activarCliente(Cliente cliente){

        cliente = clienteService.encontrarCliente(cliente);

        cliente.setEstado(true);

        clienteService.guardar(cliente);


        return "redirect:/admin/dash-clientes";
    }
    @GetMapping("/cliente/productos")
    public String productos(Model model){
        List<Producto> product = productoService.listarProductos();
        model.addAttribute("productos",product);
        return "/cliente/productos";
    }
    @GetMapping("/cliente/planes")
    public String planes(){
        return "/cliente/planes";
    }
    @GetMapping("/cliente/noticias")
    public String noticias(){
        return "/cliente/noticias";
    }
    @GetMapping("/index")
    public String index(){
        return "/index";
    }

}
