package com.hba.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Account implements Serializable {
    @Id
    @Column(name = "account_no")
    private int accountNo;
    @Column(name = "account_holder_nm")
    private String accountHolderName;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "ifsc_code")
    private String ifscCode;
    @Column(name = "reg_mobile_no")
    private String registeredMobileNo;
    @Column(name = "reg_email_address")
    private String registeredEmailAddress;
    private double balance;

}
