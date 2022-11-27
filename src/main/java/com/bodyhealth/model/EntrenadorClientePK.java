package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
@Data
public class EntrenadorClientePK implements Serializable {
    @Column(name = "id_entrenador")
    private int id_entrenador;
    @Column(name = "id_cliente")
    private int id_cliente;
}
