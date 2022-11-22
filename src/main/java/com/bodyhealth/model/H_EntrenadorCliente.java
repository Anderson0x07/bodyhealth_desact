package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "h_entrenadorcliente")
@IdClass(H_EntrenadorClientePK.class)
public class H_EntrenadorCliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentoE;
    @ManyToOne
    @JoinColumn(name = "documentoE",insertable = false,updatable = false)
    private Entrenador entrenador;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentoC;
    @ManyToOne
    @JoinColumn(name = "documentoC",insertable = false,updatable = false)
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_horario_entrenador;
    @ManyToOne
    @JoinColumn(name = "id_horario_entrenador",insertable = false,updatable = false)
    private HorarioEntrenador horarioEntrenador;
}
