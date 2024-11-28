package com.hb3.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Passport implements Serializable {
    private int passportNo;
    private String passportHolderName;
    private LocalDate issuedDate;
    private LocalDate expiryDate;
    private String issuedAuthority;

    public int getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(int passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportHolderName() {
        return passportHolderName;
    }

    public void setPassportHolderName(String passportHolderName) {
        this.passportHolderName = passportHolderName;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getIssuedAuthority() {
        return issuedAuthority;
    }

    public void setIssuedAuthority(String issuedAuthority) {
        this.issuedAuthority = issuedAuthority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport passport)) return false;
        return getPassportNo() == passport.getPassportNo() && Objects.equals(getPassportHolderName(), passport.getPassportHolderName()) && Objects.equals(getIssuedDate(), passport.getIssuedDate()) && Objects.equals(getExpiryDate(), passport.getExpiryDate()) && Objects.equals(getIssuedAuthority(), passport.getIssuedAuthority());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassportNo(), getPassportHolderName(), getIssuedDate(), getExpiryDate(), getIssuedAuthority());
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportNo=" + passportNo +
                ", passportHolderName='" + passportHolderName + '\'' +
                ", issuedDate=" + issuedDate +
                ", expiryDate=" + expiryDate +
                ", issuedAuthority='" + issuedAuthority + '\'' +
                '}';
    }
}
