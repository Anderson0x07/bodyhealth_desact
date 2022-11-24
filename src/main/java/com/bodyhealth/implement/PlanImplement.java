package com.bodyhealth.implement;

import com.bodyhealth.model.Plan;
import com.bodyhealth.repository.PlanRepository;
import com.bodyhealth.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanImplement implements PlanService {
    @Autowired
    private PlanRepository planRepository;
    @Override
    public List<Plan> listarPlanes() {
        return (List<Plan>) planRepository.findAll();
    }

    @Override
    public void guardar(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public void eliminar(Plan plan) {
        planRepository.delete(plan);
    }

    @Override
    public Plan encontrarPlan(Plan plan) {
        return planRepository.findById(plan.getId_plan()).orElse(null);
    }
}
