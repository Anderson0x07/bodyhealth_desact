package com.bodyhealth.repository;

import com.bodyhealth.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan,Integer> {
}
