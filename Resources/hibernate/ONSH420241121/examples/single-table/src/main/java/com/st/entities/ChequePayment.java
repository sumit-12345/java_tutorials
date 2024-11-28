package com.st.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Data
@DiscriminatorValue("cheque")
@Entity
public class ChequePayment extends Payment {
    @Column(name = "cheque_no")
    private String chequeNo;
    @Column(name = "bank_nm")
    private String bankName;
    @Column(name = "cheque_dt")
    private LocalDate chequeDate;
    @Column(name = "payee_account_no")
    private String payeeAccountNo;
    @Column(name = "payee_nm")
    private String payeeName;

}

