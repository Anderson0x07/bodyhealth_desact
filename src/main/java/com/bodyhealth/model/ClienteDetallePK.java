package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class ClienteDetallePK implements Serializable {
    @Column(name = "documentoC",insertable = false,updatable = false)
    private Cliente cliente;
    @Column(name = "id_detalle",insertable = false,updatable = false)
    private Detalle detalle;
    private int documentoC;
    private Date fecha_inicio;
}
