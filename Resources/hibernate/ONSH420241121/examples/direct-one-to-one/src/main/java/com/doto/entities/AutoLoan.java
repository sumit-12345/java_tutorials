package com.doto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="auto_loan")
public class AutoLoan implements Serializable {
    @Id
    @Column(name = "loan_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanNo;
    @Column(name = "applicant_nm")
    private String applicantName;
    private int tenure;
    @Column(name = "principle_amt")
    private double principleAmount;
    @Column(name = "interest_rate")
    private double interestRate;

}
