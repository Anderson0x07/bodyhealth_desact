package com.bodyhealth.implement;

import com.bodyhealth.model.Administrador;
import com.bodyhealth.repository.AdminRepository;
import com.bodyhealth.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Administrador> listarAdministradores() {
        return (List<Administrador>) adminRepository.findAll();
    }

    @Override
    public void guardar(Administrador administrador) {
        adminRepository.save(administrador);
    }

    @Override
    public void eliminar(Administrador administrador) {
        adminRepository.delete(administrador);
    }

    @Override
    public Administrador encontrarAdministrador(Administrador administrador) {

        return adminRepository.findById(administrador.getId_admin()).orElse(null);
    }

    /*@Override
    @Transactional(readOnly = true)
    public Administrador buscarAdmin(Administrador admin) {
        return adminRepo.findById(admin.getDocumento()).orElse(null);
    }*/
}
