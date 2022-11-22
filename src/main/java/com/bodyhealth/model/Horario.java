package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "horario")
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_horario;

    private String jornada;
    @ManyToOne
    @JoinColumn(name = "id_diasemana")
    private DiasSemana id_diasemana;

}
