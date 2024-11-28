package com.mto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(builderMethodName = "of")
@Entity
@Table(name = "associate")
@AllArgsConstructor
@NoArgsConstructor
public class Associate {
    @Id
    @Column(name = "associate_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int associateNo;
    private String fullname;
    private String designation;
    private LocalDate doj;
    private int experience;

    @ManyToOne
    @JoinColumn(name = "assigned_project_no", nullable = false)
    private Project assignedProject;
}
