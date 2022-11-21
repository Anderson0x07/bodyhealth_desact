package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class HorarioEntrenadorPK implements Serializable {
    @Column(name = "documentoE")
    private int documentoE;
    @Column(name = "id_horario")
    private int id_horario;
}
