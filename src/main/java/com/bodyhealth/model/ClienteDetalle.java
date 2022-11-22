package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "cliente_detalle")
@IdClass(ClienteDetallePK.class)
public class ClienteDetalle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentoC;
    @ManyToOne
    @JoinColumn(name = "documentoC",insertable = false,updatable = false,nullable = false)
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle;
    @ManyToOne
    @JoinColumn(name = "id_detalle",insertable = false,updatable = false,nullable = false)
    private Detalle detalle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fecha_inicio;

    private Date fecha_fin;

    @ManyToOne
    @JoinColumn(name = "id_metodopago")
    private MetodoPago id_metodopago;
}
