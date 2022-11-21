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
    @PrimaryKeyJoinColumn(name = "documentoE",foreignKey = @ForeignKey(name = "FK_E_HEC"))
    private Entrenador entrenador;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documento;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "documento",foreignKey = @ForeignKey(name = "FK_C_HEC"))
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_horario;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_horario",foreignKey = @ForeignKey(name = "FK_H_HEC"))
    private Horario horario;
}
