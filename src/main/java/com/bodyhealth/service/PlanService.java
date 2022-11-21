package com.bodyhealth.service;

import com.bodyhealth.model.Plan;
import com.bodyhealth.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {
    public List<Plan> listarPlanes();

    public void guardar(Plan plan);

    public void eliminar(Plan plan);

    public Plan encontrarPlan(Plan plan);
}
