package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "horario_entrenador")
public class HorarioEntrenador implements Serializable {
    @Id
    private int id_horario_entrenador;

    @ManyToOne
    @JoinColumn(name = "documentoE")
    //@PrimaryKeyJoinColumn(name = "documentoE",foreignKey = @ForeignKey(name = "FK_E_HE"))
    private Entrenador documentoE;

    @ManyToOne
    @JoinColumn(name = "id_horario")
    //@PrimaryKeyJoinColumn(name = "id_horario",foreignKey = @ForeignKey(name = "FK_H_HE"))
    private Horario id_horario;



}
