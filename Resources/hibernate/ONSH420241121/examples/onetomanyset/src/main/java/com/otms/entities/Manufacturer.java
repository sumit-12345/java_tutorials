package com.otms.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {
    @Id
    @Column(name = "manufacturer_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manufacturerNo;
    @Column(name = "business_nm")
    private String businessName;
    @Column(name = "established_dt")
    private LocalDate establishedDate;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_no")
    private Set<Product> products;

    public int getManufacturerNo() {
        return manufacturerNo;
    }

    public void setManufacturerNo(int manufacturerNo) {
        this.manufacturerNo = manufacturerNo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerNo=" + manufacturerNo +
                ", businessName='" + businessName + '\'' +
                ", establishedDate=" + establishedDate +
                ", contactNo='" + contactNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", products=" + products +
                '}';
    }
}

