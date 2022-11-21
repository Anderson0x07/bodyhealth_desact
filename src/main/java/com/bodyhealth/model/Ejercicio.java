package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@Table(name = "ejercicio")
@IdClass(EjercicioPK.class)
public class Ejercicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ejercicio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_musculo;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_musculo",foreignKey = @ForeignKey(name = "FK_M_E"))
    private Musculo musculo;
    private String descripcion;
    private String series;
    private int repeticiones;
    private String url_video;
}
