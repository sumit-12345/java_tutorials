package com.getvsload.entities;

import java.io.Serializable;
import java.util.Objects;

public final class Customer implements Serializable, ICustomer {
    private int customerNo;
    private String fullname;
    private int age;
    private String gender;
    private String mobileNo;
    private String emailAddress;

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getCustomerNo() == customer.getCustomerNo() && getAge() == customer.getAge() && Objects.equals(getFullname(), customer.getFullname()) && Objects.equals(getGender(), customer.getGender()) && Objects.equals(getMobileNo(), customer.getMobileNo()) && Objects.equals(getEmailAddress(), customer.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerNo(), getFullname(), getAge(), getGender(), getMobileNo(), getEmailAddress());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNo=" + customerNo +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
