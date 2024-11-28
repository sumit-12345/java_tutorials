package com.txmgmt.entities;

import java.io.Serializable;
import java.util.Objects;

public class Job implements Serializable {
    private int jobNo;
    private String jobTitle;
    private String description;
    private String location;
    private String designation;
    private double salary;

    public int getJobNo() {
        return jobNo;
    }

    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return getJobNo() == job.getJobNo() && Double.compare(getSalary(), job.getSalary()) == 0 && Objects.equals(getJobTitle(), job.getJobTitle()) && Objects.equals(getDescription(), job.getDescription()) && Objects.equals(getLocation(), job.getLocation()) && Objects.equals(getDesignation(), job.getDesignation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJobNo(), getJobTitle(), getDescription(), getLocation(), getDesignation(), getSalary());
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobNo=" + jobNo +
                ", jobTitle='" + jobTitle + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
