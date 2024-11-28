package com.ci.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Embeddable
public class LoanApplicationID implements Serializable {
    @Column(name = "application_no")
    private int applicationNo;
    @Column(name = "branch_code")
    private String branchCode;
}
