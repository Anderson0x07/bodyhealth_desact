package com.bodyhealth.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_compra;
}
