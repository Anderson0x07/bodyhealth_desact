package com.bodyhealth.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "administrador")
public class Administrador implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_admin;

    private int documentoA;

    private String tipodocumento;

    private String nombre;

    private String apellido;

    private String telefono;

    private Date fecha_nacimiento;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name="id_rol")
    private Rol id_rol;
}
