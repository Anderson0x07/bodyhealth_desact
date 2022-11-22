package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "compra")
public class Compra implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_compra;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente id_cliente;

    @ManyToOne
    @JoinColumn(name="id_metodopago")
    private MetodoPago id_metodopago;
}
