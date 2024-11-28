package com.flc.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "trip")
public class Trip implements Serializable {
    @Id
    @Column(name = "trip_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripNo;
    @Column(name = "trip_nm")
    private String tripName;
    private String source;
    private String destination;
    @Column(name = "planned_dt")
    private LocalDate plannedDate;
    private double amount;
}
