package com.hibernatetools.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_no")
    private int addressNo;
    @Column(name = "address_line1", length = 80, nullable = false)
    private String addressLine1;
    @Column(name = "address_line2", length = 80, nullable = true)
    private String addressLine2;
    @Column(name = "city", length = 50, nullable = false)
    private String city;
    @Column(name = "state", length = 50, nullable = false)
    private String state;
    @Column(name = "zip", length = 6, nullable = false)
    private int zip;
    /*@Column(name = "country", length = 50, nullable = false)
    private String country;*/
    /*@Column(name = "landmark", length = 100, nullable = true)
    private String landmark;*/
    private String county;
}
