package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "control_cliente")
@IdClass(ControlClientePK.class)
public class ControlCliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentoC;
    @ManyToOne
    @JoinColumn(name = "documentoC",insertable = false,updatable = false)
    //@PrimaryKeyJoinColumn(name = "documento",foreignKey = @ForeignKey(name = "FK_C_CC"))
    private Cliente cliente;
    private double peso;
    private double estatura;
    @Id
    private Date fecha;

}
