package com.mtm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trip")
public class Trip implements Serializable {
    @Id
    @Column(name = "trip_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripNo;

    private String source;
    private String destination;
    @Column(name = "journey_dt")
    private LocalDate journeyDate;
    private int days;
    private double cost;

    @ManyToMany
    @JoinTable(name = "trip_passenger", joinColumns = {@JoinColumn(name = "trip_no")},
            inverseJoinColumns = {@JoinColumn(name = "passenger_no")})
    private Set<Passenger> passengers;
}
