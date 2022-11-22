package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
@Data
public class H_EntrenadorClientePK implements Serializable {
    @Column(name = "documentoE")
    private int documentoE;

    @Column(name = "documentoC")
    private int documentoC;

    @Column(name = "id_horario_entrenador")
    private int id_horario_entrenador;
}
