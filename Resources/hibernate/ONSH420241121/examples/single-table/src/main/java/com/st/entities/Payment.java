package com.st.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("cash")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bill_no")
    private String billNo;
    @Column(name = "payment_dt")
    private LocalDate paymentDate;
    private String description;
    private double amount;
    @Column(name = "payment_status")
    private String paymentStatus;
}
