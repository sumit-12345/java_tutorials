package com.inverse.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(exclude = "products")
@ToString(exclude = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_no")
    private int manufacturerNo;
    @Column(name = "business_nm")
    private String businessName;
    @Column(name = "established_dt")
    private LocalDate establishedDate;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "email_address")
    private String emailAddress;
    @OneToMany(mappedBy = "manufacturer")
    @BatchSize(size = 5)
    private Set<Product> products;
}
