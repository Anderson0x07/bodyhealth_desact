package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
@Data
public class H_EntrenadorClientePK implements Serializable {
    @Column(name = "documentoE")
    private int documentoE;
    @Column(name = "documento")
    private int documento;
    @Column(name = "id_horario")
    private int id_horario;
}
