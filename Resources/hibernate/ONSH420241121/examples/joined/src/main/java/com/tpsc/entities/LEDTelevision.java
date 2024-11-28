package com.tpsc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Entity
@Table(name = "led_television")
@PrimaryKeyJoinColumn(name = "led_television_product_code")
public class LEDTelevision extends Television {
    @Column(name = "led_technology")
    private String ledTechnology;
    @Column(name = "refresh_rate")
    private int refreshRate;
}
