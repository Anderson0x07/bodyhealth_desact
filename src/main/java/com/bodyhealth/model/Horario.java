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
    private int id;

    private String jornada;

    private int id_diasemana;
    @ManyToOne
    @PrimaryKeyJoinColumn
    private DiasSemana diasSemana;

}
