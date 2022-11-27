package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "entrenador_cliente")
@IdClass(EntrenadorClientePK.class)
public class EntrenadorCliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_entrenador;
    @ManyToOne
    @JoinColumn(name = "id_entrenador",insertable = false,updatable = false,nullable = false)
    private Entrenador entrenador;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    @ManyToOne
    @JoinColumn(name = "id_cliente",insertable = false,updatable = false,nullable = false)
    private Cliente cliente;
}
