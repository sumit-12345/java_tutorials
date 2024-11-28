package com.jpaconfig.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class RechargePlan implements Serializable {
    private int planNo;
    private String planName;
    private String description;
    private String circle;
    private int validityDays;
    private double rechargeAmount;

}
