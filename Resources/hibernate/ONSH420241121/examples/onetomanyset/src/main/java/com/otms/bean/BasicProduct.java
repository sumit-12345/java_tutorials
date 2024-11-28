package com.otms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicProduct {
    private int productNo;
    private String productName;
    private double price;

}
