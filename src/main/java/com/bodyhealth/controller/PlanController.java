package com.bodyhealth.controller;

import com.bodyhealth.model.Detalle;
import com.bodyhealth.model.Plan;
import com.bodyhealth.service.DetalleService;
import com.bodyhealth.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private DetalleService detalleService;

    @GetMapping("/dash-planes")
    public String listarPlanes(Model model){

        List<Plan> planes = planService.listarPlanes();

        model.addAttribute("planes",planes);
        model.addAttribute("planesDeta",listarPlanesDetallados());
        return "/admin/dash-planes";
    }

    public List<Detalle> listarPlanesDetallados(){
        return detalleService.listarDetalles();
    }
}
