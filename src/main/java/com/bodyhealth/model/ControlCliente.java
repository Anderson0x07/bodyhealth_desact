package com.bodyhealth.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Cliente cliente;
    private double peso;
    private double estatura;
    //@Id
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha;

}
