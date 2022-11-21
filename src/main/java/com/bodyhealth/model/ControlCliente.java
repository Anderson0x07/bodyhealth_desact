package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "control_cliente")
@IdClass(ControlClientePK.class)
public class ControlCliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documento;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "documento",foreignKey = @ForeignKey(name = "FK_C_CC"))
    private Cliente cliente;

}
