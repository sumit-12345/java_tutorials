package com.hba.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address", schema = "hibdb")
public class Address {
    @Id
    @Column(name = "address_no", nullable = false)
    private Integer id;

    @Column(name = "address_line1", length = 45)
    private String addressLine1;

    @Column(name = "address_line2", length = 45)
    private String addressLine2;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "state", length = 45)
    private String state;

    @Column(name = "zip")
    private Integer zip;

    @Column(name = "country", length = 45)
    private String country;

}