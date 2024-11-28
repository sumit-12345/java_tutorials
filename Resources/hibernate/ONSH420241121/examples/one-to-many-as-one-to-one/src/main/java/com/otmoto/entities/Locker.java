package com.otmoto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "of")
@Entity
@Table(name = "locker")
public class Locker implements Serializable {
    @Id
    @Column(name = "locker_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lockerNo;
    @Column(name = "key_no")
    private String keyNo;
    private String dimensions;
    private double charges;

}
