package com.bodyhealth.model;

import lombok.AllArgsConstructor;
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
    private int documentoE;
    @ManyToOne
    @JoinColumn(name = "documentoE",insertable = false,updatable = false,nullable = false)
    private Entrenador entrenador;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentoC;
    @ManyToOne
    @JoinColumn(name = "documentoC",insertable = false,updatable = false,nullable = false)
    private Cliente cliente;
}
