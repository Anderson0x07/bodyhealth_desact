package com.bodyhealth.service;


import com.bodyhealth.model.Administrador;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminService {

    public Administrador buscarAdmin(Administrador admin);
}
