package com.hba.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "account", schema = "hibdb")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_no", nullable = false)
    private Integer id;

    @Column(name = "account_holder_nm", length = 45)
    private String accountHolderNm;

    @Column(name = "account_type", length = 45)
    private String accountType;

    @Column(name = "ifsc_code", length = 45)
    private String ifscCode;

    @Column(name = "reg_mobile_no", length = 45)
    private String regMobileNo;

    @Column(name = "reg_email_address", length = 45)
    private String regEmailAddress;

    @Column(name = "balance")
    private Float balance;

}