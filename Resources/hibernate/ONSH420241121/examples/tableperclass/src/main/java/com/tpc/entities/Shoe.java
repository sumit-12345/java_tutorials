package com.tpc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(builderMethodName = "of")
@NoArgsConstructor
@Entity
@Table(name = "shoe")
public class Shoe extends Product {
    private int size;
    @Column(name = "sole_type")
    private String soleType;
    private String purpose;
}
