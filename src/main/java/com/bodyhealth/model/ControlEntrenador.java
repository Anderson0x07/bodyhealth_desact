package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "control_entrenador")
@IdClass(ControlEntrenadorPK.class)
public class ControlEntrenador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentoE;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "documentoE",foreignKey = @ForeignKey(name = "FK_E_CE"))
    private Entrenador entrenador;

    private double peso;
    private double estatura;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fecha;
}
