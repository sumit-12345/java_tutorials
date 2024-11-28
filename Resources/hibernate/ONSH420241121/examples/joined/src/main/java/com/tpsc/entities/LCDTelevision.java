package com.tpsc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lcd_television")
@PrimaryKeyJoinColumn(name = "lcd_television_product_code")
public class LCDTelevision extends Television {
    @Column(name = "panel_type")
    private String panelType;
    private String resolution;
}
