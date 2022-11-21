package com.bodyhealth.model;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
@Data
public class ControlClientePK implements Serializable {
    @Column(name = "documento")
    private int documento;
}
