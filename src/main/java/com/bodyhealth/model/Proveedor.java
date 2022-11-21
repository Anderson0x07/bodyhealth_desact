package com.bodyhealth.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="proveedor")
public class Proveedor implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;


    private String nombreEmpresa;


    private String telefono;


    private String direccion;
}
