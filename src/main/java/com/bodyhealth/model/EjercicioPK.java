package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
@Data
public class EjercicioPK implements Serializable {
    @Column(name = "id_musculo")
    private int id_musculo;
}
