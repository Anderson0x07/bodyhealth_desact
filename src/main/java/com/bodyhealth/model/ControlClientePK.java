package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class ControlClientePK implements Serializable {
    @Column(name = "documentoC")
    private int documentoC;

    //private Date fecha;
}
