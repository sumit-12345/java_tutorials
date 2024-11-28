package com.tpsc.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "television")
@Inheritance(strategy = InheritanceType.JOINED)
public class Television implements Serializable {
    @Id
    @Column(name = "television_product_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int televisionProductCode;
    @Column(name = "serial_no")
    private String serialNo;
    @Column(name = "model_nm")
    private String modelName;
    private String manufacturer;
    private String dimensions;
    private double price;

}
