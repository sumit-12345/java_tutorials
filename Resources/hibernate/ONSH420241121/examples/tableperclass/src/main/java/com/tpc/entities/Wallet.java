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
@Table(name = "wallet")
public class Wallet extends Product {
    @Column(name = "wallet_type")
    private String walletType;
    private int sections;
    private String material;

}
