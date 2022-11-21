package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "horario_entrenador")
@IdClass(HorarioEntrenadorPK.class)
public class HorarioEntrenador implements Serializable {
    @Id
    private int documentoE;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "documentoE",foreignKey = @ForeignKey(name = "FK_E_HE"))
    private Entrenador entrenador;

    @Id
    private int id_horario;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_horario",foreignKey = @ForeignKey(name = "FK_H_HE"))
    private Horario horario;



}
