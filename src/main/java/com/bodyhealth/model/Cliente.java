package com.bodyhealth.model;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentoC;

    private String tipo_documento;

    private String nombre;

    private String apellido;

    private String telefono;

    private Date fechaN;

    private String email;

    private String password;

    private String foto;

    private String jornada;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol id_rol;
}
