package com.mtm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "of")
@Entity
@Table(name = "passenger")
public class Passenger implements Serializable {
    @Id
    @Column(name = "passenger_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerNo;
    @Column(name = "full_nm")
    private String fullName;
    private int age;
    private String gender;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "email_address")
    private String emailAddress;
}
