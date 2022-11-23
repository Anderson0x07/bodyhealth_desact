package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
@Data
public class EntrenadorClientePK implements Serializable {
    @Column(name = "documentoE")
    private int documentoE;
    @Column(name = "documentoC")
    private int documentoC;
}
