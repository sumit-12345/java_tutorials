package com.dyninsupd.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "passenger")
@DynamicInsert
@DynamicUpdate
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_no")
    private int passengerNo;
    @Column(name = "full_nm")
    private String fullname;
    private int age;
    private String gender;
    @Column(name = "mobile_nbr")
    private String mobileNo;
    @Column(name = "email_address")
    private String emailAddress;

}
