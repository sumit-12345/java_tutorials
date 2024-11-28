package com.idgen.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
/*@TableGenerator(name = "product_table_generator", table = "global_unique_keys",
        pkColumnName = "pk_col_nm", pkColumnValue = "product_no", valueColumnName = "pk_col_val", allocationSize = 1)*/
public class Product {
    @Id
    @Column(name = "product_no")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_table_generator")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productNo;
    @Column(name = "product_nm")
    private String productName;
    @Column(name = "manufacturer_nm")
    private String manufacturer;
    private String category;
    private double price;
}
