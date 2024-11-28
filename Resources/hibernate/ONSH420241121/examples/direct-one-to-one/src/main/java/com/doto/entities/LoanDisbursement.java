package com.doto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan_disbursement")
public class LoanDisbursement implements Serializable {
    @Id
    @Column(name = "loan_no")
    private int loanNo;
    @Column(name = "disbursement_dt")
    private LocalDate disbursementDate;
    @Column(name = "cheque_no")
    private String chequeNo;
    @Column(name = "cheque_dt")
    private LocalDate chequeDate;
    @Column(name = "paid_to")
    private String paidTo;
    @Column(name = "disbursement_amt")
    private double disbursementAmount;

    @MapsId
    @OneToOne
    private AutoLoan autoLoan;
}
