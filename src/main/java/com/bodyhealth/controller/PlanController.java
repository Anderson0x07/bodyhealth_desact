package com.bodyhealth.controller;

import com.bodyhealth.model.Plan;
import com.bodyhealth.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/lista")
    public List<Plan> listarPlanes(){
        return planService.listarPlanes();
    }
}
