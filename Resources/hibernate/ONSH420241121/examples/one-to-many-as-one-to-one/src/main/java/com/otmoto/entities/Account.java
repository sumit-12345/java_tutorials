package com.otmoto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @Column(name = "account_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNo;
    @Column(name = "account_holder_nm")
    private String accountHolderName;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "ifsc_code")
    private String ifscCode;
    private double balance;

    @OneToMany
    @JoinColumn(name = "issued_account_no", unique = true)
    private Set<Locker> assignedLockers;
}
