package com.ci.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "loan_application")
public class LoanApplication implements Serializable {
    @EmbeddedId
    private LoanApplicationID id;
    @Column(name = "applicant_nm")
    private String applicantName;
    @Column(name = "applied_dt")
    private LocalDate appliedDate;
    @Column(name = "loan_type")
    private String loanType;
    private double amount;
}
