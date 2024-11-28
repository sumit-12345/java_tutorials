package com.dmlops.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "traffic_challan")
@Data
public class TrafficChallan {
    @Id
    @Column(name = "challan_no")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int challanNo;
    @Column(name = "vehicle_registration_no")
    private String vehicleRegistrationNo;
    @Column(name = "drivers_license_no")
    private String driversLicenseNo;
    @Column(name = "challan_dt")
    private LocalDate challanDate;
    @Column(name = "reason_for_challan")
    private String reasonForChallan;
    private double amount;
}
